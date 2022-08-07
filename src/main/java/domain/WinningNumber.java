package domain;

import java.util.Objects;

public class WinningNumber implements Comparable<WinningNumber> {
    private final int MIN_LOTTO_NUMBER = 1;

    private final int MAX_LOTTO_NUMBER = 45;

    private final int number;

    private final BallType ballType;

    public WinningNumber(int number, BallType ballType) {
        validate(number);
        this.number = number;
        this.ballType = ballType;
    }

    public int getNumber() {
        return number;
    }

    private void validate(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    public String toString() {
        return Integer.toString(number);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        WinningNumber that = (WinningNumber) o;
        return number == that.number && ballType == that.ballType;
    }

    public int hashCode() {
        return Objects.hash(number, ballType);
    }

    public int compareTo(WinningNumber o) {
        return number - o.getNumber();
    }
}
