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

    private final int prizeMoney;
    private final int matchCount;
    private final boolean bonus;

    Rank(int prizeMoney, int matchCount, boolean bonus) {
        this.prizeMoney = prizeMoney;
        this.matchCount = matchCount;
        this.bonus = bonus;
    }

    private int getMatchCount() {
        return getMatchCount();
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
