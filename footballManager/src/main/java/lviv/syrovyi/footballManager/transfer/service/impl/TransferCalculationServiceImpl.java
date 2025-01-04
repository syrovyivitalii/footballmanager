package lviv.syrovyi.footballManager.transfer.service.impl;

import lviv.syrovyi.footballManager.player.repository.entity.Player;
import lviv.syrovyi.footballManager.team.repository.entity.Team;
import lviv.syrovyi.footballManager.transfer.service.TransferCalculationService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class TransferCalculationServiceImpl implements TransferCalculationService {

    @Override
    public BigDecimal calculateTransferPrice(Player player) {
        Integer experience = player.getExperience();

        Integer age = player.getAge();

        return BigDecimal.valueOf((experience * 100000)/age);
    }

    @Override
    public BigDecimal calculateCommission(Team team, BigDecimal transferPrice) {
        BigDecimal teamCommission = team.getCommissionRate();

        return teamCommission.multiply(transferPrice)
                .divide(BigDecimal.valueOf(100), RoundingMode.HALF_UP);
    }


    @Override
    public boolean enoughTeamBudgetToBuyPlayer(Team team, BigDecimal totalFee) {
        BigDecimal teamBudget = team.getBudget();

        return teamBudget.compareTo(totalFee) > 0;
    }
}
