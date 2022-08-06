package domain;

import java.util.List;

public class LottoResult {
    private final List<Rank> ranks;

    private final int investMoney;

    public LottoResult(List<Rank> ranks, int investMoney) {
        this.ranks = ranks;
        this.investMoney = investMoney;
    }

    public double earningRate() {
        int earning = 0;
        for (Rank rank : ranks) {
            earning += rank.prize();
        }
        return (double) earning / investMoney;
    }

    public List<Rank> getRanks() {
        return ranks;
    }
}
