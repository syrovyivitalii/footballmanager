package lviv.syrovyi.footballManager.team.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeamTransferredResponseDTO {
    private UUID id;
    private String name;
}
