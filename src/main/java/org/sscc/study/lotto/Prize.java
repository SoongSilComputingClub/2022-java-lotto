package org.sscc.study.lotto;

import java.util.Arrays;

public enum Prize {
    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    FIRST(6, 2000000000);

    private final int number;
    private final int prize;

    Prize(int number, int prize) {
        this.number = number;
        this.prize = prize;
    }

    public static int getPrize(int number) {
        Prize result = Arrays.stream(Prize.values())
                .filter(value -> value.number == number)
                .findAny()
                .orElse(null);
        return result == null ? 0 : result.prize;
    }
}
