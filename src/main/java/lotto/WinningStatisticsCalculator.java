package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

public class WinningStatisticsCalculator {
    private final HashMap<WinningHistory, Integer> winningHistory;

    public WinningStatisticsCalculator(List<Lotto> lottos, Lotto winningNumbers, int bonusNumber) {
        this.winningHistory = new HashMap<>() {{
            put(WinningHistory.FIRST_PRIZE, 0);
            put(WinningHistory.SECOND_PRIZE, 0);
            put(WinningHistory.THIRD_PRIZE, 0);
            put(WinningHistory.FOURTH_PRIZE, 0);
            put(WinningHistory.FIFTH_PRIZE, 0);
            put(WinningHistory.BLANK, 0);
        }};
    }

    public HashMap<WinningHistory, Integer> getWinningHistory() {
        return winningHistory;
    }

    private int getMatchNumbers(Lotto lotto, Lotto winningNumbers) {
        return (int) lotto.getNumbers().stream()
                .filter(number -> winningNumbers.getNumbers().stream().anyMatch(Predicate.isEqual(number)))
                .count();
    }

    private boolean isMatchBonusNumber(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
