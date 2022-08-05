package domain;

import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> winnerMap;

    public LottoResult(Map<Rank, Integer> winnerMap) {
        this.winnerMap = winnerMap;
    }

    public double earningRate(LottoPurchaseMoney lottoPurchaseMoney) {
        int earning = 0;
        for (Map.Entry<Rank, Integer> entry : winnerMap.entrySet()) {
            earning += entry.getKey().prize() * entry.getValue();
        }

        int price = 1000 * lottoPurchaseMoney.maxCount();

        return (double) earning / price;
    }

    public Map<Rank, Integer> winnerMap() {
        return winnerMap;
    }
}
