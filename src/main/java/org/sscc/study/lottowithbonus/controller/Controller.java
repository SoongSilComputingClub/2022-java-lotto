package org.sscc.study.lottowithbonus.controller;

import org.sscc.study.lottowithbonus.domain.InputMoney;
import org.sscc.study.lottowithbonus.domain.LotteryMachine;
import org.sscc.study.lottowithbonus.domain.WinningNumbers;
import org.sscc.study.lottowithbonus.domain.WinningStat;
import org.sscc.study.lottowithbonus.view.InputView;
import org.sscc.study.lottowithbonus.view.ResultView;

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
        WinningStat winningStat = lotteryMachine.getStat(winningNumbers);
        resultView.printStat(winningStat);
        resultView.printPortfolio(winningStat.portfolio(money.getMoney()));
    }
}