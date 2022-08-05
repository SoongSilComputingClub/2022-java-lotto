package org.sscc.study.lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LotteryTicket {
    private final List<Integer> lotteryNumbers = new ArrayList<>();

    public LotteryTicket(List<Integer> numbers) {
        lotteryNumbers.addAll(numbers);
    }

    public List<Integer> getLotteryTicket() {
        return lotteryNumbers;
    }
}
