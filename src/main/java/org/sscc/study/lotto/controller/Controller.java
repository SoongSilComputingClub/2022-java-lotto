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
        Record record = lottery.getTickets();

        ResultView resultView = new ResultView();
        resultView.printLottoNumbers(record);

        InputWinningNumbers winningNumbers = inputView.inputWinningNumbers();
        Winning winning = new Winning(winningNumbers.getWinningNumbers());
        WinningStat winningStat = winning.getStat(record);
        resultView.printStat(winningStat);
        resultView.printPortfolio(winningStat.portfolio(money.getMoney()));
    }
}