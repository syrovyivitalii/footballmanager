package lviv.syrovyi.footballManager.player.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lviv.syrovyi.footballManager.common.dto.response.PageResponse;
import lviv.syrovyi.footballManager.player.controller.dto.request.PlayerRequestDTO;
import lviv.syrovyi.footballManager.player.controller.dto.response.PlayerResponseDTO;
import lviv.syrovyi.footballManager.player.service.PlayerService;
import lviv.syrovyi.footballManager.player.service.filter.PlayerFilter;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/players")
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping("/pageable")
    public ResponseEntity<PageResponse<PlayerResponseDTO>> getAllPlayers(@ParameterObject PlayerFilter playerFilter,
                                                                         @SortDefault(sort = "lastName", direction = Sort.Direction.ASC) @ParameterObject Pageable pageable) {
        PageResponse<PlayerResponseDTO> allPlayers = playerService.getAllPlayers(playerFilter, pageable);

        return ResponseEntity.ok(allPlayers);
    }

    @PostMapping
    public ResponseEntity<PlayerResponseDTO> save (@Valid @RequestBody PlayerRequestDTO playerRequestDTO) {
        PlayerResponseDTO savedPlayer = playerService.save(playerRequestDTO);

        return ResponseEntity.ok(savedPlayer);
    }
}
