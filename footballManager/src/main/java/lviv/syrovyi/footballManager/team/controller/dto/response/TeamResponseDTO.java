package lviv.syrovyi.footballManager.team.controller.dto.response;

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
public class TeamResponseDTO {
    private UUID id;
    private String name;
    private BigDecimal budget;
    private BigDecimal commissionRate;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
