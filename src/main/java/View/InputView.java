package View;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public int getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public String getWinner() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        scanner.nextLine();
        return scanner.nextLine();
    }
}
