package lviv.syrovyi.footballManager.team.mapper;

import javax.annotation.processing.Generated;
import lviv.syrovyi.footballManager.team.controller.dto.response.TeamResponseDTO;
import lviv.syrovyi.footballManager.team.repository.entity.Team;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-03T13:29:26+0000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class TeamMapperImpl implements TeamMapper {

    @Override
    public TeamResponseDTO mapToDTO(Team team) {
        if ( team == null ) {
            return null;
        }

        TeamResponseDTO.TeamResponseDTOBuilder teamResponseDTO = TeamResponseDTO.builder();

        teamResponseDTO.id( team.getId() );
        teamResponseDTO.name( team.getName() );
        teamResponseDTO.budget( team.getBudget() );
        teamResponseDTO.commissionRate( team.getCommissionRate() );
        teamResponseDTO.createdDate( team.getCreatedDate() );
        teamResponseDTO.updatedDate( team.getUpdatedDate() );

        return teamResponseDTO.build();
    }
}
