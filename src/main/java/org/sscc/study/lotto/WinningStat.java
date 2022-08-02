package org.sscc.study.lotto;

import java.util.HashMap;
import java.util.Map;

public class WinningStat {
    private final Map<Integer, Integer> portfolio = new HashMap<>();

    public WinningStat() {
        for (int i = 0; i <= 6; i++) {
            portfolio.put(i, 0);
        }
    }

    public void add(int number) {
        portfolio.replace(number, portfolio.get(number) + 1);
    }

    public int get(int number) {
        return portfolio.get(number);
    }

    public int totalPrize() {
        int total = 0;
        for (int i : portfolio.keySet()) {
            total += Prize.getPrize(i) * portfolio.get(i);
        }
        return total;
    }
}
