package org.sscc.study.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Winning {
    private final List<Integer> winningNumber;
    private final WinningStat winningStat = new WinningStat();

    public Winning(String numbers) {
        winningNumber = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(numbers, ", ");
        while (st.hasMoreTokens()) {
            winningNumber.add(Integer.parseInt(st.nextToken()));
        }
    }

    public WinningStat getStat(Record record) {
        for (int i : record.duplicateNumbers(winningNumber)) {
            winningStat.add(i);
        }
        return winningStat;
    }
}
