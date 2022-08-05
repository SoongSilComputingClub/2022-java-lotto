package org.sscc.study.lotto;

import java.util.List;

public class RandomLottoNumber implements NumberStrategy {
    private final LottoNumber lottoNumber;
    private static final int NUMBER = 6;

    public RandomLottoNumber() {
        lottoNumber = new LottoNumber();
    }

    @Override
    public List<Integer> getNumber() {
        return lottoNumber.getLottoNumbers(NUMBER);
    }
}
