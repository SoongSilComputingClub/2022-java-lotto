package org.sscc.study.lotto.controller;

import org.sscc.study.lotto.domain.*;
import org.sscc.study.lotto.view.InputView;
import org.sscc.study.lotto.view.ResultView;

public class Controller {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        InputMoney money = inputView.inputPrice();

        Lottery lottery = new Lottery();
        lottery.pay(money.getMoney());
        lottery.drawNumbers(new RandomLottoNumber());

        ResultView resultView = new ResultView();
        resultView.printNumber(lottery.getNumber());
        resultView.printLottoNumbers(lottery.getString());

        InputWinningNumbers winningNumbers = inputView.inputWinningNumbers();
        WinningStat winningStat = lottery.getStat(winningNumbers.getWinningNumbers());
        resultView.printStat(winningStat);
        resultView.printPortfolio(winningStat.portfolio(money.getMoney()));
    }
}