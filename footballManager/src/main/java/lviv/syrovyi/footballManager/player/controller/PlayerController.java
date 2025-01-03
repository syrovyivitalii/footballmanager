package lviv.syrovyi.footballManager.player.controller;

import lombok.RequiredArgsConstructor;
import lviv.syrovyi.footballManager.common.dto.response.PageResponse;
import lviv.syrovyi.footballManager.player.controller.dto.response.PlayerResponseDTO;
import lviv.syrovyi.footballManager.player.service.PlayerService;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/players")
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping
    public ResponseEntity<PageResponse<PlayerResponseDTO>> getAllPlayers(@SortDefault(sort = "lastName", direction = Sort.Direction.ASC) @ParameterObject Pageable pageable) {
        PageResponse<PlayerResponseDTO> allPlayers = playerService.getAllPlayers(pageable);

        return ResponseEntity.ok(allPlayers);
    }
}
