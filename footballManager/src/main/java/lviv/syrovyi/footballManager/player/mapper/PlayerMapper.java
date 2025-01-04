package lviv.syrovyi.footballManager.player.mapper;

import lviv.syrovyi.footballManager.player.controller.dto.request.PlayerRequestDTO;
import lviv.syrovyi.footballManager.player.controller.dto.response.PlayerResponseDTO;
import lviv.syrovyi.footballManager.player.repository.entity.Player;
import lviv.syrovyi.footballManager.team.controller.dto.request.TeamRequestDTO;
import lviv.syrovyi.footballManager.team.repository.entity.Team;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface PlayerMapper {

    Player mapToEntity (PlayerRequestDTO playerRequestDTO);

    PlayerResponseDTO mapToDTO (Player player);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void patchMerge(PlayerRequestDTO playerRequestDTO, @MappingTarget Player player);
}
