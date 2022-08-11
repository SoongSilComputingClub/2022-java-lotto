package domain;

public class LottoPurchaseMoney {
    private static final int LOTTO_PRICE = 1000;

    private final int autoDrawAmount;

    private final int manualDrawAmount;

    public LottoPurchaseMoney(String money, String manualDrawAmount) {
        int krw = Integer.parseInt(money);
        validateMoney(krw);
        int manual = Integer.parseInt(manualDrawAmount);
        validateAmount(manual, krw);

        this.manualDrawAmount = manual;
        this.autoDrawAmount = krw / LOTTO_PRICE - manual;
    }

    private void validateMoney(int krw) {
        if (krw < LOTTO_PRICE) {
            throw new IllegalArgumentException("구매 금액이 부족합니다.");
        }
    }

    private void validateAmount(int manual, int krw) {
        if (manual * LOTTO_PRICE > krw) {
            throw new IllegalArgumentException("구매 금액이 부족합니다.");
        }
    }

    public int getLottoAmount() {
        return autoDrawAmount + manualDrawAmount;
    }

    public int getInvestMoney() {
        return (autoDrawAmount + manualDrawAmount) * LOTTO_PRICE;
    }

    public int getAutoDrawAmount() {
        return autoDrawAmount;
    }
}
