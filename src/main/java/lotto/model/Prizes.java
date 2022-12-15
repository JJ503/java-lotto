package lotto.model;

import lotto.constants.Rank;

import java.util.HashMap;
import java.util.Map;

public class Prizes {
    private final Map<Rank, Integer> prizes = new HashMap<>();
    private int totalPrizeMoney = 0;

    public Prizes() {
        prizes.put(Rank.FIRST_PRIZE, 0);
        prizes.put(Rank.SECOND_PRIZE, 0);
        prizes.put(Rank.THIRD_PRIZE, 0);
        prizes.put(Rank.FORTH_PRIZE, 0);
        prizes.put(Rank.FIFTH_PRIZE, 0);
    }

    public void addPrize(Prize prize) {
        Rank rank = prize.getRank();
        prizes.put(rank, prizes.get(rank) + 1);
        totalPrizeMoney += rank.getPrizeMoney();
    }

    public Map<Rank, Integer> getPrizes() {
        return prizes;
    }

    public int getTotalPrizeMoney() {
        return totalPrizeMoney;
    }
}
