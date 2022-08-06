package org.sscc.study.lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LotteryTicket {
    private final List<Integer> lotteryNumbers = new ArrayList<>();

    public LotteryTicket(List<Integer> numbers) {
        lotteryNumbers.addAll(numbers);
    }

    public String getString() {
        return "[" + lotteryNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(",")) + "]";
    }

    public int checkNumbers(List<Integer> winningNumber) {
        return (int) winningNumber.stream()
                .filter(lotteryNumbers::contains)
                .count();
    }
}
