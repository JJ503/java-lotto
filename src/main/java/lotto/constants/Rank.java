package lotto.constants;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Rank {
    FIRST_PRIZE(2_000_000_000, 6, false),
    SECOND_PRIZE(30_000_000, 5, true),
    THIRD_PRIZE(1_500_000, 5, false),
    FORTH_PRIZE(50_000, 4, false),
    FIFTH_PRIZE(5_000, 3, false),
    NONE(0, 0, false);

    private static final Map<Integer, Rank> RANK_BY_MATCH_COUNT = Stream.of(values())
            .collect(Collectors.toMap(Rank::getMatchCount, Function.identity()));
    private static final String SECOND_PRIZE_MESSAGE_FORMAT = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개";
    private static final String MESSAGE_FORMAT = "%d개 일치 (%,d원) - %d개";

    private final int prizeMoney;
    private final int matchCount;
    private final boolean bonus;

    Rank(int prizeMoney, int matchCount, boolean bonus) {
        this.prizeMoney = prizeMoney;
        this.matchCount = matchCount;
        this.bonus = bonus;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    private int getMatchCount() {
        return matchCount;
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

        return RANK_BY_MATCH_COUNT.get(matchCount);
    }

    private static Rank isSecondOrThirdPrize(boolean bonus) {
        if (bonus) {
            return SECOND_PRIZE;
        }

        return THIRD_PRIZE;
    }
}
