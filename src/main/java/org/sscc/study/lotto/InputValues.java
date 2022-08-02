package org.sscc.study.lotto;

public class InputValues {
    private final int price;
    private String winningNumbers;

    public InputValues(int price) {
        this.price = price;
    }

    public void addWinningNumbers(String winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public int getPrice() {
        return price;
    }

    public String getWinningNumbers() {
        return winningNumbers;
    }
}
