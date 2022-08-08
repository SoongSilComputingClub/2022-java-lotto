package org.sscc.study.lotto.domain;

import java.util.Arrays;

public enum Prize {
    NONE(2, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int number;
    private final int prize;

    Prize(int number, int prize) {
        this.number = number;
        this.prize = prize;
    }

    public int getNumber() {
        return number;
    }

    public int getPrize() {
        return prize;
    }

    public static int getPrize(MatchData matchData) {
        Prize result = Arrays.stream(Prize.values())
                .filter(value -> matchData.getNumber() > Prize.NONE.number && value.number == matchData.getNumber())
                .findAny()
                .orElse(Prize.NONE);
        if (result.number == THIRD.number) {
            return confirmBonus(matchData);
        }
        return result.prize;
    }

    private static int confirmBonus(MatchData matchData) {
        if (matchData.hasBonus()) {
            return SECOND.prize;
        }
        return THIRD.prize;
    }
}