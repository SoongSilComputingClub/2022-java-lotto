package org.sscc.study.lotto;

public class Controller {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.inputPrice();
        InputValues inputValues = inputView.getInputValues();

        Lottery lottery = new Lottery();
        lottery.pay(inputValues.getMoney());
        lottery.drawNumbers(new RandomLottoNumber());
        Record record = lottery.getTickets();

        OutputView outputView = new OutputView();
        outputView.printLottoNumbers(record);

        inputView.inputWinningNumbers();
        Winning winning = new Winning(inputValues.getWinningNumbers());
        WinningStat winningStat = winning.getStat(record);
        outputView.printStat(winningStat);
        outputView.printPortfolio(winningStat.portfolio(inputValues.getMoney()));
    }
}
