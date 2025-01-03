package lviv.syrovyi.footballManager.player.service;

import lviv.syrovyi.footballManager.common.dto.response.PageResponse;
import lviv.syrovyi.footballManager.player.controller.dto.request.PlayerRequestDTO;
import lviv.syrovyi.footballManager.player.controller.dto.response.PlayerResponseDTO;
import org.springframework.data.domain.Pageable;

public interface PlayerService {
    PageResponse<PlayerResponseDTO> getAllPlayers(Pageable pageable);

    PlayerResponseDTO save (PlayerRequestDTO playerRequestDTO);
}
