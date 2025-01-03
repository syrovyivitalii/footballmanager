package lviv.syrovyi.footballManager.team.controller.dto.request;

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
    private BigDecimal budget;
    private BigDecimal commissionRate;
}
