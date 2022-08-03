package org.sscc.study.lotto;

import java.util.HashMap;
import java.util.Map;

public class WinningStat {
    private static final int NUMBER = 6;
    private final Map<Integer, Integer> stat = new HashMap<>();

    public WinningStat() {
        for (int i = 0; i <= NUMBER; i++) {
            stat.put(i, 0);
        }
    }

    public void add(int number) {
        stat.replace(number, stat.get(number) + 1);
    }

    public int get(int number) {
        return stat.get(number);
    }

    private int totalPrize() {
        return stat.keySet().stream()
                .reduce((total, n) -> total + Prize.getPrize(n) * stat.get(n))
                .orElse(0);
    }

    public double portfolio(int price){
        return (double)totalPrize()/price;
    }
}
