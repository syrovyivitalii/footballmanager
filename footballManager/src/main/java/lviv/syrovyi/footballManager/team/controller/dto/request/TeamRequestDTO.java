package lviv.syrovyi.footballManager.team.controller.dto.request;

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

    private String name;
    @NotNull
    private BigDecimal budget;
    private BigDecimal commissionRate;
}
