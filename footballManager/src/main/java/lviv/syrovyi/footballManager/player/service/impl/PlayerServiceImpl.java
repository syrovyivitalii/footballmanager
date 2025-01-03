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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    @Override
    public PageResponse<PlayerResponseDTO> getAllPlayers(Pageable pageable) {
        Page<Player> allPlayers = playerRepository.findAll(pageable);

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
}
