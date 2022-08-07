package org.sscc.study.lottowithbonus.domain;

import java.util.HashMap;
import java.util.Map;

public class WinningStat {
    private static final int NUMBER = 6;
    private final Map<MatchData, Integer> stat = new HashMap<>();

    public WinningStat() {
        for (int i = 0; i <= NUMBER; i++) {
            stat.put(new MatchData(i, false), 0);
            stat.put(new MatchData(i, true), 0);
        }
    }

    public void add(MatchData matchData) {
        stat.replace(matchData, stat.get(matchData) + 1);
    }

    public int get(int number) {
        return stat.keySet().stream()
                .filter(n -> n.getNumber() == number)
                .map(stat::get)
                .reduce(Integer::sum)
                .orElse(0);
    }

    public int get(int number, boolean bonus) {
        return stat.keySet().stream()
                .filter(n -> n.getNumber() == number && n.hasBonus() == bonus)
                .map(stat::get)
                .reduce(Integer::sum)
                .orElse(0);
    }

    private int totalPrize() {
        return stat.keySet().stream()
                .map(n -> Prize.getPrize(n) * stat.get(n))
                .reduce(Integer::sum)
                .orElse(0);
    }

    public double portfolio(int price) {
        return (double) totalPrize() / price;
    }
}
