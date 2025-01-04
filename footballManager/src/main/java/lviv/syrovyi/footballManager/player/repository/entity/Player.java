package lviv.syrovyi.footballManager.player.repository.entity;

import jakarta.persistence.*;
import lombok.*;
import lviv.syrovyi.footballManager.common.entity.BaseEntity;
import lviv.syrovyi.footballManager.team.repository.entity.Team;
import lviv.syrovyi.footballManager.transfer.repository.entity.Transfer;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;
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

    @UpdateTimestamp
    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Team team;

    @OneToMany(mappedBy = "player", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    private List<Transfer> transfers;
}
