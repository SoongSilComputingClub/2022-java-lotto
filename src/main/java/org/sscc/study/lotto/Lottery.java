package org.sscc.study.lotto;

public class Lottery {
    private int number;
    private LotteryTickets lotteryTickets;

    public void pay(int price) {
        this.number = price / 1000;
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
