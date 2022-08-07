package org.sscc.study.lottowithbonus.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LotteryTickets {
    private final List<LotteryTicket> lotteryTickets;

    public LotteryTickets() {
        lotteryTickets = new ArrayList<>();
    }

    public void addLotteryTicket(NumberStrategy numberStrategy) {
        lotteryTickets.add(new LotteryTicket(numberStrategy.getNumber()));
    }

    public List<MatchData> duplicateNumbers(WinningNumbers winningNumber) {
        return lotteryTickets.stream()
                .map(x -> x.getMatchData(winningNumber))
                .collect(Collectors.toList());
    }

    public String getString() {
        return lotteryTickets.stream()
                .map(LotteryTicket::getString)
                .collect(Collectors.joining("\n"));
    }
}
