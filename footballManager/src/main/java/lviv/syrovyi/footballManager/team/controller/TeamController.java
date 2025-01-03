package lviv.syrovyi.footballManager.team.controller;

import lombok.RequiredArgsConstructor;
import lviv.syrovyi.footballManager.common.dto.response.PageResponse;
import lviv.syrovyi.footballManager.team.controller.dto.response.TeamResponseDTO;
import lviv.syrovyi.footballManager.team.service.TeamService;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/teams")
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @GetMapping
    public ResponseEntity<PageResponse<TeamResponseDTO>> getAllTeams(@ParameterObject Pageable pageable) {
        PageResponse<TeamResponseDTO> allTeams = teamService.getAllTeams(pageable);

        return ResponseEntity.ok(allTeams);
    }

    @GetMapping("/{teamId}")
    public ResponseEntity<TeamResponseDTO> getTeamById(@PathVariable UUID teamId) {
        TeamResponseDTO teamById = teamService.getTeamById(teamId);

        return ResponseEntity.ok(teamById);
    }

    @DeleteMapping("{/teamId}")
    public ResponseEntity<Void> deleteTeamById(@PathVariable UUID teamId) {
        teamService.deleteTeamById(teamId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
