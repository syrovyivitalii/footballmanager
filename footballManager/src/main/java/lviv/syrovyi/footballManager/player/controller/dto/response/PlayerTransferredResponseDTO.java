package lviv.syrovyi.footballManager.player.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerTransferredResponseDTO {
    private UUID id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Integer experience;
}
