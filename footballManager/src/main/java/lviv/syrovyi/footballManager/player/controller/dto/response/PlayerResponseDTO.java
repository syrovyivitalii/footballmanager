package lviv.syrovyi.footballManager.player.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lviv.syrovyi.footballManager.team.controller.dto.response.TeamResponseDTO;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerResponseDTO {
    private UUID id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Integer experience;
    private TeamResponseDTO team;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
