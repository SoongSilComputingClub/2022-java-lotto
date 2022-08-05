package domain;

public class LottoMachine {
    private final LottoNumberGenerator generator;
    private final LottoPurchaseMoney lottoPurchaseMoney;
    private LottoTickets lottoTickets;

    public LottoMachine(LottoPurchaseMoney lottoPurchaseMoney) {
        this.generator = new LottoNumberGenerator();
        this.lottoPurchaseMoney = lottoPurchaseMoney;
    }

    public void purchase() {
        lottoTickets = new LottoTickets(lottoPurchaseMoney.getAmount(), generator);
    }

    public LottoResult confirm(WinningNumbers winningNumbers) {
        return new LottoResult(lottoTickets.findWinner(winningNumbers), lottoPurchaseMoney.getInvestMoney());
    }

    public String ticketsToString() {
        return lottoTickets.toString();
    }

    public int ticketsCount() {
        return lottoTickets.totalCount();
    }
}
