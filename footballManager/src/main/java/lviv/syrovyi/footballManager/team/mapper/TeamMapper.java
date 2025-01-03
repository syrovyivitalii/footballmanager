package lviv.syrovyi.footballManager.team.mapper;

import lviv.syrovyi.footballManager.team.controller.dto.request.TeamRequestDTO;
import lviv.syrovyi.footballManager.team.controller.dto.response.TeamResponseDTO;
import lviv.syrovyi.footballManager.team.repository.entity.Team;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeamMapper {

//    Team mapToEntity (TeamRequestDTO teamRequestDTO);

    TeamResponseDTO mapToDTO (Team team);
}
