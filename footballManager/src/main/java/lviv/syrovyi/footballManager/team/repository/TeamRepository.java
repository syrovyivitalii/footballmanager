package lviv.syrovyi.footballManager.team.repository;

import lviv.syrovyi.footballManager.team.repository.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TeamRepository extends JpaRepository<Team, UUID> {

    boolean existsByName(String name);
}
