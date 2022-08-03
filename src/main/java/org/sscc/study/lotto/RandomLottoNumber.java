package org.sscc.study.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLottoNumber implements NumberStrategy {
    private final List<Integer> lotteryNumbers;
    private static final int NUMBER = 6;

    public RandomLottoNumber() {
        lotteryNumbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            lotteryNumbers.add(i);
        }
    }

    @Override
    public List<Integer> getNumber() {
        shuffle();
        return lotteryNumbers.subList(0, NUMBER);
    }

    private void shuffle() {
        Collections.shuffle(lotteryNumbers);
    }
}
