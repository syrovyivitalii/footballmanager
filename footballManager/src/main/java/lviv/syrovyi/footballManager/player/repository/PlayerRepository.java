package lviv.syrovyi.footballManager.player.repository;

import lviv.syrovyi.footballManager.player.repository.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PlayerRepository extends JpaRepository<Player, UUID> {
}
