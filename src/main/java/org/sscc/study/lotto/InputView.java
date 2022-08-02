package org.sscc.study.lotto;

import java.util.Scanner;

public class InputView {
    private final Scanner sc = new Scanner(System.in);
    private InputValues inputValues;

    public void inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        inputValues = new InputValues(sc.nextInt());
    }

    public InputValues getInputValues() {
        return inputValues;
    }

    public void inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        sc.nextLine();
        inputValues.addWinningNumbers(sc.nextLine());
    }
}
