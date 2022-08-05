package Domain;

public class LottoMachine {
    private LottoTickets lottoTickets;

    public void purchase(LottoPurchaseMoney lottoPurchaseMoney) {
        lottoTickets = new LottoTickets(lottoPurchaseMoney.maxCount(), new LottoNumberGenerator());
    }

    public LottoResult confirm(WinningNumbers winningNumbers) {
        return lottoTickets.findWinner(winningNumbers);
    }

    public String ticketsToString() {
        return lottoTickets.toString();
    }

    public int ticketsCount() {
        return lottoTickets.totalCount();
    }
}
