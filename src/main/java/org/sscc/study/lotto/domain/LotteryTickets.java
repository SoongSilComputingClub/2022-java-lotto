package org.sscc.study.lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LotteryTickets {
    private final List<LotteryTicket> lotteryTickets;

    public LotteryTickets() {
        lotteryTickets = new ArrayList<>();
    }

    public void addLotteryTicket(List<Integer> numbers) {
        Collections.sort(numbers);
        lotteryTickets.add(new LotteryTicket(numbers));
    }

    public List<Integer> duplicateNumbers(List<Integer> winningNumber) {
        return lotteryTickets.stream()
                .map(x -> x.checkNumbers(winningNumber))
                .collect(Collectors.toList());
    }

    public String getString() {
        return lotteryTickets.stream()
                .map(LotteryTicket::getString)
                .collect(Collectors.joining("\n"));
    }
}
