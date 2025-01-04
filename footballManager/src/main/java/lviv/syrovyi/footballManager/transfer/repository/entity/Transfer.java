package lviv.syrovyi.footballManager.transfer.repository.entity;

import jakarta.persistence.*;
import lombok.*;
import lviv.syrovyi.footballManager.common.entity.BaseEntity;
import lviv.syrovyi.footballManager.player.repository.entity.Player;
import lviv.syrovyi.footballManager.team.repository.entity.Team;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Player player;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_team_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Team salesTeam;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_team_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Team bayerTeam;
}
