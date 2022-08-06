package org.sscc.study.lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputWinningNumbers {
    private final List<Integer> winningNumbers;

    public InputWinningNumbers(String input) {
        winningNumbers = new ArrayList<>();
        getWinningNumbers(input);
    }

    private void getWinningNumbers(String input) {
        StringTokenizer st = new StringTokenizer(input, ", ");
        while (st.hasMoreTokens()) {
            winningNumbers.add(Integer.parseInt(st.nextToken()));
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
