package org.sscc.study.lotto.domain;

import java.util.*;

public class RandomLottoNumberGenerator implements NumberStrategy {
    private final List<LottoNumber> lottoNumbers = new ArrayList<>();
    private static final int MAXIMUM = 45;
    private static final int MINIMUM = 1;
    private static final int NUMBER = 6;

    public RandomLottoNumberGenerator() {
        for (int i = MINIMUM; i <= MAXIMUM; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }
    }

    @Override
    public Set<LottoNumber> getNumber() {
        Collections.shuffle(lottoNumbers);
        return new HashSet<>(lottoNumbers.subList(0, NUMBER));
    }
}