package lviv.syrovyi.footballManager.team.service;

import lviv.syrovyi.footballManager.common.dto.response.PageResponse;
import lviv.syrovyi.footballManager.team.controller.dto.response.TeamResponseDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface TeamService {
    PageResponse<TeamResponseDTO> getAllTeams(Pageable pageable);

    TeamResponseDTO getTeamById(UUID id);

    void deleteTeamById(UUID id);
}
