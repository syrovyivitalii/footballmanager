package lviv.syrovyi.footballManager.team.service;

import lviv.syrovyi.footballManager.team.controller.dto.response.TeamResponseDTO;

import java.util.List;

public interface TeamService {
    List<TeamResponseDTO> getAllTeams();
}
