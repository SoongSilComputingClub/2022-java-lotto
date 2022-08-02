package org.sscc.study.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLottoNumber implements NumberStrategy {
    private final List<Integer> lotteryNumbers;

    public RandomLottoNumber() {
        lotteryNumbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            lotteryNumbers.add(i);
        }
    }

    @Override
    public List<Integer> getNumber() {
        shuffle();
        return lotteryNumbers.subList(0, 7);
    }

    private void shuffle() {
        Collections.shuffle(lotteryNumbers);
    }
}
