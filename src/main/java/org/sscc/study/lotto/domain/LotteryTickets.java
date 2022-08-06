package org.sscc.study.lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LotteryTickets {
    private final List<LotteryTicket> lotteryTickets;

    public LotteryTickets() {
        lotteryTickets = new ArrayList<>();
    }

    public void addLotteryTicket(NumberStrategy numberStrategy) {
        lotteryTickets.add(new LotteryTicket(numberStrategy.getNumber()));
    }

    public List<Integer> duplicateNumbers(Set<LottoNumber> winningNumber) {
        return lotteryTickets.stream()
                .map(x -> x.checkDuplicates(winningNumber))
                .collect(Collectors.toList());
    }

    public String getString() {
        return lotteryTickets.stream()
                .map(LotteryTicket::getString)
                .collect(Collectors.joining("\n"));
    }
}
