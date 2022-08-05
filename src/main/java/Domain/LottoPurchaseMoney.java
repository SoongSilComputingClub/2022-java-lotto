package Domain;

public class LottoPurchaseMoney {
    private final int lottoPurchaseMoney;

    public LottoPurchaseMoney(int krw) {
        validateMoney(krw);
        this.lottoPurchaseMoney = krw;
    }

    private void validateMoney(int krw) {
        if (krw < 1000) {
            throw new IllegalArgumentException();
        }
    }

    public int maxCount() {
        return (lottoPurchaseMoney / 1000);
    }
}
