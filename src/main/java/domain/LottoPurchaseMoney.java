package domain;

public class LottoPurchaseMoney {
    private static final int LOTTO_PRICE = 1000;

    private final int lottoPurchaseMoney;

    private final int lottoInvestMoney;

    public LottoPurchaseMoney(int krw) {
        validateMoney(krw);
        this.lottoPurchaseMoney = krw;
        this.lottoInvestMoney = krw / LOTTO_PRICE * LOTTO_PRICE;
    }

    private void validateMoney(int krw) {
        if (krw < LOTTO_PRICE) {
            throw new IllegalArgumentException("구매 금액이 부족합니다.");
        }
    }

    public int getAmount() {
        return lottoPurchaseMoney / LOTTO_PRICE;
    }

    public int getInvestMoney() {
        return lottoInvestMoney;
    }
}
