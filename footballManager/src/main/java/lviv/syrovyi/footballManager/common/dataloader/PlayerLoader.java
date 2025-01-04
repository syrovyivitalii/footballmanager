package lviv.syrovyi.footballManager.common.dataloader;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lviv.syrovyi.footballManager.player.controller.dto.request.PlayerRequestDTO;
import lviv.syrovyi.footballManager.player.service.PlayerService;
import lviv.syrovyi.footballManager.team.service.TeamService;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Consumer;

@Slf4j
@Component
@RequiredArgsConstructor
public class PlayerLoader implements Consumer<List<Map<String, Object>>> {
    private final PlayerService playerService;
    private final TeamService teamService;

    @Override
    public void accept(List<Map<String, Object>> maps) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        maps.stream().filter(x -> x.containsKey("players"))
                .forEach(x ->
                        ((List<HashMap>) x.get("players")).forEach(y -> {
                            PlayerRequestDTO playerRequestDTO = mapper.convertValue(y, PlayerRequestDTO.class);
                            // Assign a random teamId if not provided
                            if (playerRequestDTO.getTeamId() == null) {
                                Optional<UUID> randomTeamId = teamService.getRandomTeamId();
                                if (randomTeamId.isPresent()) {
                                    playerRequestDTO.setTeamId(randomTeamId.get());
                                } else {
                                    log.error("No teams available to assign to player: {} {}",
                                            playerRequestDTO.getFirstName(), playerRequestDTO.getLastName());
                                    return; // Skip saving the player
                                }
                            }
                            // Save the player if not already existing
                            if (!playerService.existsByFirstNameAndLastNameAndAge(
                                    playerRequestDTO.getFirstName(),
                                    playerRequestDTO.getLastName(),
                                    playerRequestDTO.getAge())) {
                                playerService.save(playerRequestDTO);
                            }
                        })
                );
    }
}
