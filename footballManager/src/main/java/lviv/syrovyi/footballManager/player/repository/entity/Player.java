package lviv.syrovyi.footballManager.player.repository.entity;

import jakarta.persistence.*;
import lombok.*;
import lviv.syrovyi.footballManager.common.entity.BaseEntity;
import lviv.syrovyi.footballManager.team.repository.entity.Team;

import java.util.UUID;

@Entity
@Table(name = "players")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Player extends BaseEntity {

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private Integer experience;

    @Column(name = "team_id", nullable = false)
    private UUID teamId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Team team;
}
