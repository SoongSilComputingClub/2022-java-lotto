package org.sscc.study.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Record {
    private final List<List<Integer>> tickets = new ArrayList<>();

    public Record(List<LotteryTicket> tickets) {
        for (LotteryTicket ticket : tickets) {
            this.tickets.add(ticket.getLotteryTicket());
        }
    }

    public int getNumber() {
        return tickets.size();
    }

    public String numbersToString(int i) {
        return tickets.get(i).stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    public List<Integer> duplicateNumbers(List<Integer> winningNumber) {
        return tickets.stream()
                .map(x -> checkNumbers(x, winningNumber))
                .collect(Collectors.toList());
    }

    private int checkNumbers(List<Integer> ticket, List<Integer> winningNumber) {
        return (int) winningNumber.stream()
                .filter(ticket::contains)
                .count();
    }
}
