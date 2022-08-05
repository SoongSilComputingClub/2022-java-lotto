package org.sscc.study.lotto;

import java.util.Arrays;

public enum Prize {
    NONE(0, 0),
    FOURTH(3, 5000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000);

    private final int number;
    private final int prize;

    Prize(int number, int prize) {
        this.number = number;
        this.prize = prize;
    }

    public static int getPrize(int number) {
        Prize result = Arrays.stream(Prize.values())
                .filter(value -> number > Prize.NONE.number && value.number == number)
                .findAny()
                .orElse(Prize.NONE);
        return result == Prize.NONE ? 0 : result.prize;
    }
}
