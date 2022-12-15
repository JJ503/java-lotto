package lotto.model;

import lotto.constants.Rank;

import java.util.List;

public class Prize {
    private final Rank rank;

    public Prize(Lotto lotto, Lotto winningNumbers, BonusNumber bonusNumber) {
        this.rank = Rank.getRank(countMatchWinningNumbers(lotto, winningNumbers),
                isMatchBonusNumber(lotto, bonusNumber));
    }

    public Rank getRank() {
        return rank;
    }

    private int countMatchWinningNumbers(Lotto lotto, Lotto winningNumbers) {
        List<Integer> tempLotto = lotto.getLotto();
        tempLotto.retainAll(winningNumbers.getLotto());
        return tempLotto.size();
    }

    private boolean isMatchBonusNumber(Lotto lotto, BonusNumber bonusNumber) {
        return lotto.isMatchNumber(bonusNumber.getBonusNumber());
    }
}
