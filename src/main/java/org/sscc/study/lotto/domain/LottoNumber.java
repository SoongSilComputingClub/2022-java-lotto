package org.sscc.study.lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumber {
    private final List<Integer> lottoNumbers;
    private static final int MAXIMUM = 45;
    private static final int MINIMUM = 1;
    private static final int NUMBER = 6;

    public LottoNumber() {
        lottoNumbers = new ArrayList<>();
        for (int i = MINIMUM; i <= MAXIMUM; i++) {
            lottoNumbers.add(i);
        }
    }

    private void shuffle() {
        Collections.shuffle(lottoNumbers);
    }

    public List<Integer> getLottoNumbers() {
        shuffle();
        return lottoNumbers.subList(0, NUMBER);
    }
}
