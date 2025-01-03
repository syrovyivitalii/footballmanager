package lviv.syrovyi.footballManager.team.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lviv.syrovyi.footballManager.common.entity.BaseEntity;

import java.math.BigDecimal;

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
}
