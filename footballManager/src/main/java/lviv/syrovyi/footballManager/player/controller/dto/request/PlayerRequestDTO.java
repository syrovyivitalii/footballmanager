package lviv.syrovyi.footballManager.player.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerRequestDTO {
    private String firstName;
    private String lastName;
    private Integer age;
    private Integer experience;
    private UUID teamId;
}
