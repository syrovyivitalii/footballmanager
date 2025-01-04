package lviv.syrovyi.footballManager.transfer.repository.entity;

import jakarta.persistence.*;
import lombok.*;
import lviv.syrovyi.footballManager.common.entity.BaseEntity;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "transfers")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Transfer extends BaseEntity {

    @Column(name = "player_id")
    private UUID playerId;

    @Column(name = "from_team_id")
    private UUID fromTeamId;

    @Column(name = "to_team_id")
    private UUID toTeamId;

    @Column(name = "transfer_price")
    private BigDecimal transferPrice;

    private BigDecimal commission;

    @Column(name = "total_fee")
    private BigDecimal totalFee;
}
