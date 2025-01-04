package lviv.syrovyi.footballManager.transfer.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransferRequestDTO {

    private UUID playerId;
    private UUID fromTeamId;
    private UUID toTeamId;
    private BigDecimal transferPrice;
    private BigDecimal commission;
    private BigDecimal totalFee;
}
