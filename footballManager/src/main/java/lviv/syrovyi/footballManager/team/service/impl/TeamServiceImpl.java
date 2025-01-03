package lviv.syrovyi.footballManager.team.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lviv.syrovyi.footballManager.common.dto.response.PageResponse;
import lviv.syrovyi.footballManager.team.controller.dto.response.TeamResponseDTO;
import lviv.syrovyi.footballManager.team.mapper.TeamMapper;
import lviv.syrovyi.footballManager.team.repository.TeamRepository;
import lviv.syrovyi.footballManager.team.repository.entity.Team;
import lviv.syrovyi.footballManager.team.service.TeamService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    @Override
    public PageResponse<TeamResponseDTO> getAllTeams(Pageable pageable) {
        Page<Team> allTeams = teamRepository.findAll(pageable);

        List<TeamResponseDTO> collectedDTOs = allTeams
                .stream()
                .map(teamMapper::mapToDTO)
                .toList();

        return PageResponse.<TeamResponseDTO>builder()
                .totalPages((long) allTeams.getTotalPages())
                .pageSize((long) pageable.getPageSize())
                .totalElements(allTeams.getTotalElements())
                .content(collectedDTOs)
                .build();
    }
}
