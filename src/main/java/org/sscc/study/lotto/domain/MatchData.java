package org.sscc.study.lotto.domain;

public class MatchData {
    private final int number;
    private final boolean bonus;

    public MatchData(int number, boolean bonus) {
        this.number = number;
        this.bonus = bonus;
    }

    public int getNumber() {
        return number;
    }

    public boolean hasBonus() {
        return bonus;
    }

    @Override
    public int hashCode() {
        return number+((bonus)?100:0);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MatchData) {
            return number == ((MatchData) obj).getNumber() && bonus == ((MatchData) obj).hasBonus();
        }
        return false;
    }
}
