package Controller;

import Domain.*;
import View.InputView;
import View.ResultView;

public class Controller {
    private final InputView inputView;
    private final ResultView resultView;

    public Controller(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void execute() {
        LottoPurchaseMoney lottoPurchaseMoney = new LottoPurchaseMoney(inputView.getMoney());

        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.purchase(lottoPurchaseMoney);
        resultView.printTotalCount(lottoMachine.ticketsCount());
        resultView.printLottoTickets(lottoMachine.ticketsToString());

        WinningNumbers winningNumbers = new WinningNumbers(inputView.getWinner());

        LottoResult lottoResult = lottoMachine.confirm(winningNumbers);

        resultView.printWinnerStat(lottoResult.winnerMap());
        resultView.printEarningRatio(lottoResult.earningRate(lottoPurchaseMoney));
    }
}
