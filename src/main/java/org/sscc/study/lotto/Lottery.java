package org.sscc.study.lotto;

public class Lottery {
    private static final int PRICE = 1000;
    private int number;
    private LotteryTickets lotteryTickets;

    public void pay(int money) {
        this.number = money / PRICE;
        lotteryTickets = new LotteryTickets();
    }

    public void drawNumbers(NumberStrategy numberStrategy) {
        for (int i = 0; i < number; i++) {
            lotteryTickets.addLotteryTicket(numberStrategy.getNumber());
        }
    }

    public Record getTickets() {
        return lotteryTickets.getLotteryTickets();
    }
}
