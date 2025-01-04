package lviv.syrovyi.footballManager.transfer.repository;

import lviv.syrovyi.footballManager.transfer.repository.entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransferRepository extends JpaRepository <Transfer, UUID> {
}
