package controller;

import domain.LottoMachine;
import domain.LottoPurchaseMoney;
import domain.LottoResult;
import domain.WinningNumbers;
import view.InputView;
import view.ResultView;

public class Controller {
    private final InputView inputView;
    private final ResultView resultView;

    public Controller(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void execute() {
        LottoPurchaseMoney lottoPurchaseMoney = new LottoPurchaseMoney(inputView.getMoney(), inputView.getManualDrawAmount());
        LottoMachine lottoMachine = new LottoMachine(lottoPurchaseMoney);
        lottoMachine.purchase(inputView.getManualDraws());

        resultView.printTotalCount(lottoMachine.ticketsCount());
        resultView.printLottoTickets(lottoMachine.ticketsToString());

        WinningNumbers winningNumbers = new WinningNumbers(inputView.getWinner(), inputView.getBonusNumber());
        LottoResult lottoResult = lottoMachine.confirm(winningNumbers);

        resultView.printWinnerStat(lottoResult.getRanks());
        resultView.printEarningRatio(lottoResult.earningRate());
    }
}
