package org.sscc.study.lotto.domain;

import java.util.List;

public class Lottery {
    private static final int PRICE = 1000;
    private int number;
    private LotteryTickets lotteryTickets;
    private WinningStat winningStat;

    public void pay(int money) {
        this.number = money / PRICE;
        lotteryTickets = new LotteryTickets();
        winningStat = new WinningStat();
    }

    public void drawNumbers(NumberStrategy numberStrategy) {
        for (int i = 0; i < number; i++) {
            lotteryTickets.addLotteryTicket(numberStrategy.getNumber());
        }
    }

    public String getString() {
        return lotteryTickets.getString();
    }

    public int getNumber() {
        return number;
    }

    public WinningStat getStat(List<Integer> winningNumbers) {
        lotteryTickets.duplicateNumbers(winningNumbers).forEach(x -> winningStat.add(x));
        return winningStat;
    }
}
