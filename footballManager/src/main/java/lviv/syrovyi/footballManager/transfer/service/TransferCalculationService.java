package lviv.syrovyi.footballManager.transfer.service;

import lviv.syrovyi.footballManager.player.repository.entity.Player;
import lviv.syrovyi.footballManager.team.repository.entity.Team;

import java.math.BigDecimal;

public interface TransferCalculationService {
    BigDecimal calculateTransferPrice(Player player);

    BigDecimal calculateCommission (Team team, BigDecimal transferPrice);

    boolean enoughTeamBudgetToBuyPlayer (Team team, BigDecimal totalFee);
}
