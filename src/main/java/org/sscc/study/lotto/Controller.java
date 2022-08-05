package org.sscc.study.lotto;

public class Controller {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        InputMoney money = inputView.inputPrice();

        Lottery lottery = new Lottery();
        lottery.pay(money.getMoney());
        lottery.drawNumbers(new RandomLottoNumber());
        Record record = lottery.getTickets();

        OutputView outputView = new OutputView();
        outputView.printLottoNumbers(record);

        InputWinningNumbers winningNumbers = inputView.inputWinningNumbers();
        Winning winning = new Winning(winningNumbers.getWinningNumbers());
        WinningStat winningStat = winning.getStat(record);
        outputView.printStat(winningStat);
        outputView.printPortfolio(winningStat.portfolio(money.getMoney()));
    }
}
