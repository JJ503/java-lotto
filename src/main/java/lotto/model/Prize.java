package lotto.model;

import lotto.constants.Rank;

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
        return lotto.getMatchNumber(winningNumbers.getLotto()).size();
    }

    private boolean isMatchBonusNumber(Lotto lotto, BonusNumber bonusNumber) {
        return lotto.isMatchNumber(bonusNumber.getBonusNumber());
    }
}
