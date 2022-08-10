package org.sscc.study.lotto.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LotteryTicket {
    private final Set<LottoNumber> lotteryNumbers = new HashSet<>();

    public LotteryTicket(Set<LottoNumber> numbers) {
        lotteryNumbers.addAll(numbers);
    }

    public String getString() {
        return "[" + lotteryNumbers.stream()
                .sorted()
                .map(x -> String.valueOf(x.getNumber()))
                .collect(Collectors.joining(", ")) + "]";
    }

    public boolean checkNumber(LottoNumber lottoNumber) {
        return lotteryNumbers.contains(lottoNumber);
    }
}
