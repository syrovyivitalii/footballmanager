package lviv.syrovyi.footballManager.common.dataloader;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lviv.syrovyi.footballManager.team.controller.dto.request.TeamRequestDTO;
import lviv.syrovyi.footballManager.team.service.TeamService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@Slf4j
@Component
@RequiredArgsConstructor
public class TeamLoader implements Consumer<List<Map<String, Object>>> {

    private final TeamService teamService;

    @Override
    public void accept(List<Map<String, Object>> maps) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        maps.stream().filter(x -> x.containsKey("teams"))
                .forEach(x ->
                        ((List<HashMap>) x.get("teams")).forEach(y -> {
                            TeamRequestDTO teamRequestDTO = mapper.convertValue(y, TeamRequestDTO.class);
                            if (!teamService.existTeamByName(teamRequestDTO.getName())) {
                                teamService.save(teamRequestDTO);
                            }
                        })
                );
    }
}
