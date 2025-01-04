package lviv.syrovyi.footballManager.transfer.controller.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "Player is mandatory")
    private UUID playerId;

    @NotNull(message = "Sales team is mandatory")
    private UUID fromTeamId;

    @NotNull(message = "Bayer team is mandatory")
    private UUID toTeamId;

    @Min(value = 0, message = "Transfer price must be at least 0")
    @NotNull(message = "Transfer price is mandatory")
    private BigDecimal transferPrice;

    @Min(value = 0, message = "Commission must be at least 0")
    @Max(value = 10, message = "Commission must be at most 10")
    @NotNull(message = "Commission is mandatory")
    private BigDecimal commission;

}
