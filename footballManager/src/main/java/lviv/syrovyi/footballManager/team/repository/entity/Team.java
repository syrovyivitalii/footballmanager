package lviv.syrovyi.footballManager.team.repository.entity;

import jakarta.persistence.*;
import lombok.*;
import lviv.syrovyi.footballManager.common.entity.BaseEntity;
import lviv.syrovyi.footballManager.player.repository.entity.Player;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "teams")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Team extends BaseEntity {

    @Column(nullable = false)
    private String name;

    private BigDecimal budget;

    @Column(name = "commission_rate")
    private BigDecimal commissionRate;

    @OneToMany(mappedBy = "team", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    private List<Player> players;
}
