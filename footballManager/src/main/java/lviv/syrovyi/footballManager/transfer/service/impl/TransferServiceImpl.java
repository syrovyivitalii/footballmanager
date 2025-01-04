package lviv.syrovyi.footballManager.transfer.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lviv.syrovyi.footballManager.common.dto.response.PageResponse;
import lviv.syrovyi.footballManager.common.exception.ClientBackendException;
import lviv.syrovyi.footballManager.common.exception.ErrorCode;
import lviv.syrovyi.footballManager.player.repository.PlayerRepository;
import lviv.syrovyi.footballManager.player.repository.entity.Player;
import lviv.syrovyi.footballManager.team.repository.TeamRepository;
import lviv.syrovyi.footballManager.team.repository.entity.Team;
import lviv.syrovyi.footballManager.transfer.controller.dto.request.TransferRequestDTO;
import lviv.syrovyi.footballManager.transfer.controller.dto.response.TransferResponseDTO;
import lviv.syrovyi.footballManager.transfer.mapper.TransferMapper;
import lviv.syrovyi.footballManager.transfer.repository.TransferRepository;
import lviv.syrovyi.footballManager.transfer.repository.entity.Transfer;
import lviv.syrovyi.footballManager.transfer.service.TransferCalculationService;
import lviv.syrovyi.footballManager.transfer.service.TransferService;
import lviv.syrovyi.footballManager.transfer.service.filter.TransferFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static lviv.syrovyi.footballManager.common.specification.SpecificationCustom.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransferServiceImpl implements TransferService {

    private final TransferRepository transferRepository;
    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;
    private final TransferMapper transferMapper;
    private final TransferCalculationService transferCalculationService;

    @Override
    @Transactional
    public TransferResponseDTO transfer(TransferRequestDTO transferRequestDTO) {

        Transfer transfer = transferMapper.mapToEntity(transferRequestDTO);

        Player player = playerRepository.findById(transfer.getPlayerId())
                .orElseThrow(() -> new ClientBackendException(ErrorCode.PLAYER_NOT_FOUND));

        if (player.getTeamId().equals(transfer.getToTeamId())) {
            throw new ClientBackendException(ErrorCode.SALES_AND_BAYER_TEAM_THE_SAME);
        }

        Team salesTeam = player.getTeam();
        Team bayerTeam = teamRepository.findById(transfer.getToTeamId())
                .orElseThrow(() -> new ClientBackendException(ErrorCode.TEAM_NOT_FOUND));

        BigDecimal transferPrice = transferCalculationService.calculateTransferPrice(player);

        BigDecimal commission = transferCalculationService.calculateCommission(salesTeam, transferPrice);

        BigDecimal totalFee = transferPrice.add(commission);

        if (!transferCalculationService.enoughTeamBudgetToBuyPlayer(bayerTeam, totalFee)){
            throw new ClientBackendException(ErrorCode.INSUFFICIENT_FUNDS);
        };

        bayerTeam.setBudget(bayerTeam.getBudget().subtract(totalFee));
        salesTeam.setBudget(salesTeam.getBudget().add(totalFee));
        player.setTeam(bayerTeam);

        teamRepository.saveAll(Arrays.asList(bayerTeam, salesTeam));
        playerRepository.save(player);

        transfer.setFromTeamId(salesTeam.getId());
        transfer.setTransferPrice(transferPrice);
        transfer.setCommission(commission);
        transfer.setTotalFee(totalFee);
        Transfer savedTransfer = transferRepository.save(transfer);

        return transferMapper.mapToDTO(savedTransfer);

    }

    @Override
    public PageResponse<TransferResponseDTO> getTransfersPageable(TransferFilter transferFilter, Pageable pageable) {
        Page<Transfer> allTransfers = transferRepository.findAll(getSearchSpecification(transferFilter), pageable);

        List<TransferResponseDTO> collectedDTOs = allTransfers
                .stream()
                .map(transferMapper::mapToDTO)
                .toList();

        return PageResponse.<TransferResponseDTO>builder()
                .totalPages((long) allTransfers.getTotalPages())
                .pageSize((long) pageable.getPageSize())
                .totalElements(allTransfers.getTotalElements())
                .content(collectedDTOs)
                .build();
    }

    private Specification<Transfer> getSearchSpecification(TransferFilter transferFilter) {
        return Specification.where((Specification<Transfer>) searchLikeStringWithJoin("player", "firstName", transferFilter.getSearch()))
                .or((Specification<Transfer>) searchLikeStringWithJoin("player", "lastName", transferFilter.getSearch()))
                .or((Specification<Transfer>) searchLikeStringWithJoin("salesTeam", "name", transferFilter.getSearch()))
                .or((Specification<Transfer>) searchLikeStringWithJoin("bayerTeam", "name", transferFilter.getSearch()))
                .and((Specification<Transfer>) searchFieldInCollectionOfIds("id", transferFilter.getIds()))
                .or((Specification<Transfer>) searchFieldInCollectionOfIds("playerId", transferFilter.getIds()))
                .or((Specification<Transfer>) searchFieldInCollectionOfIds("fromTeamId", transferFilter.getIds()))
                .or((Specification<Transfer>) searchFieldInCollectionOfIds("toTeamId", transferFilter.getIds()));
    }
}
