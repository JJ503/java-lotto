package lotto.model;

import lotto.constants.Rank;

import java.util.HashMap;
import java.util.Map;

public class Prizes {
    private final Map<Rank, Integer> prizes;
    private int totalPrizeMoney = 0;

    public Prizes() {
        prizes = new HashMap<>();
        prizes.put(Rank.FIRST_PRIZE, 0);
        prizes.put(Rank.SECOND_PRIZE, 0);
        prizes.put(Rank.THIRD_PRIZE, 0);
        prizes.put(Rank.FORTH_PRIZE, 0);
        prizes.put(Rank.FIFTH_PRIZE, 0);
    }

    public void addPrize(Prize prize) {
        Rank rank = prize.getRank();
        if (!rank.equals(Rank.NONE)) {
            prizes.put(rank, prizes.get(rank) + 1);
            totalPrizeMoney += rank.getPrizeMoney();
        }
    }

    public int getPrizes(Rank rank) {
        return prizes.get(rank);
    }

    public int getTotalPrizeMoney() {
        return totalPrizeMoney;
    }
}
