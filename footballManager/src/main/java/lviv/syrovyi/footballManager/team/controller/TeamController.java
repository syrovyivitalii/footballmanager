package lviv.syrovyi.footballManager.team.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lviv.syrovyi.footballManager.common.dto.response.PageResponse;
import lviv.syrovyi.footballManager.team.controller.dto.request.TeamRequestDTO;
import lviv.syrovyi.footballManager.team.controller.dto.response.TeamResponseDTO;
import lviv.syrovyi.footballManager.team.service.TeamService;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/teams")
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @GetMapping("/pageable")
    public ResponseEntity<PageResponse<TeamResponseDTO>> getAllTeams(@ParameterObject Pageable pageable) {
        PageResponse<TeamResponseDTO> allTeams = teamService.getAllTeams(pageable);

        return ResponseEntity.ok(allTeams);
    }

    @PostMapping
    public ResponseEntity<TeamResponseDTO> save(@Valid @RequestBody TeamRequestDTO teamRequestDTO) {
        TeamResponseDTO teamResponseDTO = teamService.save(teamRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(teamResponseDTO);
    }

    @GetMapping("/{teamId}")
    public ResponseEntity<TeamResponseDTO> getTeamById(@PathVariable UUID teamId) {
        TeamResponseDTO teamById = teamService.getTeamById(teamId);

        return ResponseEntity.ok(teamById);
    }

    @DeleteMapping("/{teamId}")
    public ResponseEntity<Void> deleteTeamById(@PathVariable UUID teamId) {
        teamService.deleteTeamById(teamId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{teamId}")
    public ResponseEntity<TeamResponseDTO> patchTeam(@PathVariable UUID teamId, @RequestBody TeamRequestDTO teamRequestDTO) {
        TeamResponseDTO teamResponseDTO = teamService.patchTeam(teamId, teamRequestDTO);

        return ResponseEntity.ok(teamResponseDTO);
    }


}
