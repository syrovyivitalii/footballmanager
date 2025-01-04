package lviv.syrovyi.footballManager.transfer.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Arrays;

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

        log.info("Transfer started for player {}", transferRequestDTO.getPlayerId());

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

        log.info("Transfer completed successfully for player {}", player.getId());

        return transferMapper.mapToDTO(savedTransfer);

    }
}
