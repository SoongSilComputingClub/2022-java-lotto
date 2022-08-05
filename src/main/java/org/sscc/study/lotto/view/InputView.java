package org.sscc.study.lotto.view;

import org.sscc.study.lotto.domain.InputMoney;
import org.sscc.study.lotto.domain.InputWinningNumbers;

import java.util.Scanner;

public class InputView {
    private final Scanner sc = new Scanner(System.in);

    public InputMoney inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return new InputMoney(Integer.parseInt(sc.nextLine()));
    }

    public InputWinningNumbers inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new InputWinningNumbers(sc.nextLine());
    }
}
