package lotto.constants;

import java.util.HashMap;
import java.util.Map;

public enum Rank {
    FIFTH_PRIZE(5_000, 3),
    FORTH_PRIZE(50_000, 4),
    THIRD_PRIZE(1_500_000, 5),
    SECOND_PRIZE(30_000_000, 5),
    FIRST_PRIZE(2_000_000_000, 6),
    NONE(0, 0);

    private static final Map<Integer, Rank> RANK_BY_MATCH_COUNT = new HashMap<>() {{
        put(6, Rank.FIRST_PRIZE);
        put(4, Rank.FORTH_PRIZE);
        put(3, Rank.FIFTH_PRIZE);
    }};
    private static final String SECOND_PRIZE_MESSAGE_FORMAT = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개";
    private static final String MESSAGE_FORMAT = "%d개 일치 (%,d원) - %d개";

    private final int prizeMoney;
    private final int matchCount;

    Rank(int prizeMoney, int matchCount) {
        this.prizeMoney = prizeMoney;
        this.matchCount = matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getRankMessage(int count) {
        if (this.equals(Rank.SECOND_PRIZE)) {
            return String.format(SECOND_PRIZE_MESSAGE_FORMAT, matchCount, prizeMoney, count);
        }

        return String.format(MESSAGE_FORMAT, matchCount, prizeMoney, count);
    }

    public static Rank getRank(int matchCount, boolean bonus) {
        if (matchCount == SECOND_PRIZE.matchCount) {
            return isSecondOrThirdPrize(bonus);
        }

        return isOtherPrize(matchCount);
    }

    private static Rank isSecondOrThirdPrize(boolean bonus) {
        if (bonus) {
            return SECOND_PRIZE;
        }

        return THIRD_PRIZE;
    }

    private static Rank isOtherPrize(int matchCount) {
        if (RANK_BY_MATCH_COUNT.containsKey(matchCount)) {
            return RANK_BY_MATCH_COUNT.get(matchCount);
        }

        return Rank.NONE;
    }
}
