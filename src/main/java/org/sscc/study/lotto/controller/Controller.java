package org.sscc.study.lotto.controller;

import org.sscc.study.lotto.domain.InputMoney;
import org.sscc.study.lotto.domain.LotteryMachine;
import org.sscc.study.lotto.domain.WinningNumbers;
import org.sscc.study.lotto.domain.WinningStat;
import org.sscc.study.lotto.view.InputView;
import org.sscc.study.lotto.view.ResultView;

public class Controller {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LotteryMachine lotteryMachine = new LotteryMachine();

        InputMoney money = inputView.inputPrice();
        lotteryMachine.pay(money.getMoney());
        lotteryMachine.drawNumbers();

        resultView.printNumber(lotteryMachine.getNumber());
        resultView.printLottoNumbers(lotteryMachine.getString());

        WinningNumbers winningNumbers = inputView.inputWinningNumbers();
        WinningStat winningStat = lotteryMachine.getStat(winningNumbers.getWinningNumbers());
        resultView.printStat(winningStat);
        resultView.printPortfolio(winningStat.portfolio(money.getMoney()));
    }
}