package lviv.syrovyi.footballManager.player.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lviv.syrovyi.footballManager.common.dto.response.PageResponse;
import lviv.syrovyi.footballManager.player.controller.dto.request.PlayerRequestDTO;
import lviv.syrovyi.footballManager.player.controller.dto.response.PlayerResponseDTO;
import lviv.syrovyi.footballManager.player.mapper.PlayerMapper;
import lviv.syrovyi.footballManager.player.repository.PlayerRepository;
import lviv.syrovyi.footballManager.player.repository.entity.Player;
import lviv.syrovyi.footballManager.player.service.PlayerService;
import lviv.syrovyi.footballManager.player.service.filter.PlayerFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

import static lviv.syrovyi.footballManager.common.specification.SpecificationCustom.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    @Override
    public PageResponse<PlayerResponseDTO> getAllPlayers(PlayerFilter playerFilter, Pageable pageable) {
        Page<Player> allPlayers = playerRepository.findAll(getSearchSpecification(playerFilter), pageable);

        List<PlayerResponseDTO> collectedDTOs = allPlayers
                .stream()
                .map(playerMapper::mapToDTO)
                .toList();

        return PageResponse.<PlayerResponseDTO>builder()
                .totalPages((long) allPlayers.getTotalPages())
                .pageSize((long) pageable.getPageSize())
                .totalElements(allPlayers.getTotalElements())
                .content(collectedDTOs)
                .build();
    }

    @Override
    public PlayerResponseDTO save(PlayerRequestDTO playerRequestDTO) {
        Player player = playerMapper.mapToEntity(playerRequestDTO);

        Player savedPlayer = playerRepository.save(player);

        return playerMapper.mapToDTO(savedPlayer);
    }

    @Override
    public boolean existsByFirstNameAndLastNameAndAge(String firstName, String lastName, Integer age) {
        return playerRepository.existsByFirstNameAndLastNameAndAge(firstName, lastName, age);
    }

    private Specification<Player> getSearchSpecification(PlayerFilter playerFilter) {
        return Specification.where((Specification<Player>) searchFieldInCollectionOfIds("id", playerFilter.getId()));
    }

}
