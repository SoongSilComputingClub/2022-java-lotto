package domain;

public class LottoPurchaseMoney {
    private static final int LOTTO_PRICE = 1000;

    private final int lottoAmount;

    private final int lottoInvestMoney;

    public LottoPurchaseMoney(String input) {
        int krw = Integer.parseInt(input);
        validateMoney(krw);
        this.lottoAmount = krw / LOTTO_PRICE;
        this.lottoInvestMoney = lottoAmount * LOTTO_PRICE;
    }

    private void validateMoney(int krw) {
        if (krw < LOTTO_PRICE) {
            throw new IllegalArgumentException("구매 금액이 부족합니다.");
        }
    }

    public int getAmount() {
        return lottoAmount;
    }

    public int getInvestMoney() {
        return lottoInvestMoney;
    }
}
