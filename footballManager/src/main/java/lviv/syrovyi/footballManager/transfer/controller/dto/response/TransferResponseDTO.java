package lviv.syrovyi.footballManager.transfer.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransferResponseDTO {

    private UUID id;
    private UUID playerId;
    private UUID fromTeamId;
    private UUID toTeamId;
    private BigDecimal transferPrice;
    private BigDecimal commission;
    private BigDecimal totalFee;
    private LocalDateTime createdDate;
}
