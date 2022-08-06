package domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    NONE(0, 0);

    private final int count;
    private final int prize;

    Rank(int count, int prize) {
        this.count = count;
        this.prize = prize;
    }

    public static Rank of(int count) {
        return Arrays.stream(values())
                .filter(value -> value.count == count)
                .findFirst()
                .orElse(NONE);
    }

    public int prize() {
        return prize;
    }
}
