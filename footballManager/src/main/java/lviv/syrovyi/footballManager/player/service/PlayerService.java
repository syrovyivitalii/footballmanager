package lviv.syrovyi.footballManager.player.service;

import lviv.syrovyi.footballManager.common.dto.response.PageResponse;
import lviv.syrovyi.footballManager.player.controller.dto.request.PlayerRequestDTO;
import lviv.syrovyi.footballManager.player.controller.dto.response.PlayerResponseDTO;
import lviv.syrovyi.footballManager.player.service.filter.PlayerFilter;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface PlayerService {
    PageResponse<PlayerResponseDTO> getAllPlayers(PlayerFilter playerFilter, Pageable pageable);

    PlayerResponseDTO save (PlayerRequestDTO playerRequestDTO);

    boolean existsByFirstNameAndLastNameAndAge(String firstName, String lastName, Integer age);
}
