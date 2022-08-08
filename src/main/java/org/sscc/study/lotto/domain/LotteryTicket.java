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

    private int checkDuplicates(WinningNumbers winningNumber) {
        return (int) lotteryNumbers.stream()
                .filter(winningNumber::hasNumber)
                .count();
    }

    public MatchData getMatchData(WinningNumbers winningNumbers) {
        return new MatchData(checkDuplicates(winningNumbers), checkBonusNumber(winningNumbers));
    }

    private boolean checkBonusNumber(WinningNumbers winningNumbers) {
        return lotteryNumbers.stream()
                .anyMatch(winningNumbers::hasBonusNumber);
    }
}
