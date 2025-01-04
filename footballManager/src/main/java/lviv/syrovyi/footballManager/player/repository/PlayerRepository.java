package lviv.syrovyi.footballManager.player.repository;

import lviv.syrovyi.footballManager.player.repository.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface PlayerRepository extends JpaRepository<Player, UUID>, JpaSpecificationExecutor<Player> {

    boolean existsByFirstNameAndLastNameAndAge(String firstName, String lastName, Integer age);

    boolean existsByPlayerIdAndTeamId(UUID playerId, UUID teamId);
}
