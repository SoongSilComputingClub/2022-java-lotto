package org.sscc.study.lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StaticLottoNumber implements NumberStrategy {
    private final List<Integer> lottoNumber = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

    @Override
    public List<Integer> getNumber() {
        return lottoNumber;
    }
}
