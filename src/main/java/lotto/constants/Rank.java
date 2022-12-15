package lotto.constants;

public enum Rank {
    FIRST_PRIZE(2_000_000_000, 6, false),
    SECOND_PRIZE(30_000_000, 5, true),
    THIRD_PRIZE(1_500_000, 5, false),
    FORTH_PRIZE(50_000, 4, false),
    FIFTH_PRIZE(5_000, 3, false),
    NONE(0, 0, false);

    private final int prizeMoney;
    private final int matchCount;
    private final boolean bonus;

    Rank(int prizeMoney, int matchCount, boolean bonus) {
        this.prizeMoney = prizeMoney;
        this.matchCount = matchCount;
        this.bonus = bonus;
    }
}
