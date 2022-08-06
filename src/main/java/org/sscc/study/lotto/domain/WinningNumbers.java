package org.sscc.study.lotto.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class WinningNumbers {
    private final Set<LottoNumber> winningNumbers;

    public WinningNumbers(String input) {
        winningNumbers = new HashSet<>();
        getWinningNumbers(input);
    }

    private void getWinningNumbers(String input) {
        StringTokenizer st = new StringTokenizer(input, ", ");
        while (st.hasMoreTokens()) {
            winningNumbers.add(new LottoNumber(Integer.parseInt(st.nextToken())));
        }
        validate();
    }

    private void validate() {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 6개입니다.");
        }
    }

    public Set<LottoNumber> getWinningNumbers() {
        return winningNumbers;
    }
}
