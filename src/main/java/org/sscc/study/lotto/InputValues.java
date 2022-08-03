package org.sscc.study.lotto;

public class InputValues {
    private final int money;
    private String winningNumbers;

    public InputValues(int price) {
        this.money = price;
    }

    public void addWinningNumbers(String winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public int getMoney() {
        return money;
    }

    public String getWinningNumbers() {
        return winningNumbers;
    }
}
