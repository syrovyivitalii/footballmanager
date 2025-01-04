package lviv.syrovyi.footballManager.team.controller.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeamRequestDTO {

    @NotBlank(message = "Name is mandatory")
    private String name;

    @Min(value = 0, message = "Budget must be at least 0")
    @NotNull(message = "Budget is mandatory")
    private BigDecimal budget;

    @Min(value = 0, message = "Commission must be at least 0")
    @Max(value = 10, message = "Commission must be at most 10")
    @NotNull(message = "Commission is mandatory")
    private BigDecimal commissionRate;
}
