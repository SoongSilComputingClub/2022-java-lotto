package domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private final int MIN_LOTTO_NUMBER = 1;

    private final int MAX_LOTTO_NUMBER = 45;

    private final int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void validate(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또 당첨 번호는 1이상 45 이하 정수입니다.");
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
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    public int hashCode() {
        return Objects.hash(number);
    }

    public int compareTo(LottoNumber o) {
        return number - o.getNumber();
    }
}
