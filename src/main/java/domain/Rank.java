package domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 20_0000_0000),
    SECOND(5, 150_0000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
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
