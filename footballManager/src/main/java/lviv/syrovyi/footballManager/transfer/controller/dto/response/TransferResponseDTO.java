package lviv.syrovyi.footballManager.transfer.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lviv.syrovyi.footballManager.player.controller.dto.response.PlayerResponseDTO;
import lviv.syrovyi.footballManager.player.controller.dto.response.PlayerTransferredResponseDTO;
import lviv.syrovyi.footballManager.player.repository.entity.Player;
import lviv.syrovyi.footballManager.team.controller.dto.response.TeamResponseDTO;
import lviv.syrovyi.footballManager.team.controller.dto.response.TeamTransferredResponseDTO;
import lviv.syrovyi.footballManager.team.repository.entity.Team;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransferResponseDTO {

    private UUID id;
    private PlayerTransferredResponseDTO player;
    private TeamTransferredResponseDTO salesTeam;
    private TeamTransferredResponseDTO bayerTeam;
    private BigDecimal transferPrice;
    private BigDecimal commission;
    private BigDecimal totalFee;
    private LocalDateTime createdDate;
}
