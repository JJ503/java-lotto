package lotto.constants;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Rank {
    FIRST_PRIZE(2_000_000_000, 6),
    SECOND_PRIZE(30_000_000, 5),
    THIRD_PRIZE(1_500_000, 5),
    FORTH_PRIZE(50_000, 4),
    FIFTH_PRIZE(5_000, 3),
    NONE(0, 0);

    private static final Map<Integer, Rank> RANK_BY_MATCH_COUNT = Stream.of(values())
            .collect(Collectors.toMap(Rank::getMatchCount, Function.identity()));
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
