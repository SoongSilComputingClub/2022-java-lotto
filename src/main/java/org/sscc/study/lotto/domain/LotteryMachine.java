package org.sscc.study.lotto.domain;

public class LotteryMachine {
    private static final int PRICE = 1000;
    private int number;
    private LotteryTickets lotteryTickets;
    private WinningStat winningStat = new WinningStat();
    private final NumberStrategy numberStrategy = new RandomLottoNumberGenerator();

    public void pay(int money) {
        this.number = money / PRICE;
        lotteryTickets = new LotteryTickets();
        winningStat = new WinningStat();
    }

    public void drawNumbers() {
        for (int i = 0; i < number; i++) {
            lotteryTickets.addLotteryTicket(numberStrategy);
        }
    }

    public String getString() {
        return lotteryTickets.getString();
    }

    public int getNumber() {
        return number;
    }

    public WinningStat getStat(WinningNumbers winningNumbers) {
        lotteryTickets.duplicateNumbers(winningNumbers).forEach(winningStat::add);
        return winningStat;
    }
}
