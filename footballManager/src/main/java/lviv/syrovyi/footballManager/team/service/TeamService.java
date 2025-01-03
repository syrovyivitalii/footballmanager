package lviv.syrovyi.footballManager.team.service;

import lviv.syrovyi.footballManager.common.dto.response.PageResponse;
import lviv.syrovyi.footballManager.team.controller.dto.response.TeamResponseDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TeamService {
    PageResponse<TeamResponseDTO> getAllTeams(Pageable pageable);
}
