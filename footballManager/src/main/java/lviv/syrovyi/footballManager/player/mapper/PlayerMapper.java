package lviv.syrovyi.footballManager.player.mapper;

import lviv.syrovyi.footballManager.player.controller.dto.request.PlayerRequestDTO;
import lviv.syrovyi.footballManager.player.controller.dto.response.PlayerResponseDTO;
import lviv.syrovyi.footballManager.player.repository.entity.Player;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlayerMapper {

    Player mapToEntity (PlayerRequestDTO playerRequestDTO);

    PlayerResponseDTO mapToDTO (Player player);
}
