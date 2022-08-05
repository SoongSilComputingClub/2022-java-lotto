package org.sscc.study.lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LotteryTickets {
    private final List<LotteryTicket> lotteryTickets;

    public LotteryTickets() {
        lotteryTickets = new ArrayList<>();
    }

    public void addLotteryTicket(List<Integer> numbers) {
        Collections.sort(numbers);
        lotteryTickets.add(new LotteryTicket(numbers));
    }

    public Record getLotteryTickets() {
        return new Record(lotteryTickets);
    }
}
