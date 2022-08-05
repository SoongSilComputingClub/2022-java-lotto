package Domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;

public class LottoTicket {
    private static final int LOTTERY_NUMBER_SIZE = 6;

    private final List<Integer> lotteryNumbers;

    public LottoTicket(LottoNumberGenerator lottoNumberGenerator) {
        List<Integer> lotteryNumbers = lottoNumberGenerator.newLottoNumber();
        checkValidation(lotteryNumbers);
        this.lotteryNumbers = lotteryNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(lotteryNumbers);
    }

    public int matching(WinningNumbers winningNumbers) {
        List<Integer> myNumber = new ArrayList<>(lotteryNumbers);
        myNumber.retainAll(winningNumbers.getWinningNumbers());
        return myNumber.size();
    }

    public String toString() {
        return lotteryNumbers.toString();
    }

    private void checkValidation(List<Integer> lotteryNumbers) {
        checkSize(lotteryNumbers);
        checkUniqueness(lotteryNumbers);
    }

    private void checkSize(List<Integer> lotteryNumbers) {
        if (lotteryNumbers.size() != LOTTERY_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void checkUniqueness(List<Integer> lotteryNumbers) {
        Set<Integer> uniqueSetOfNumbers = new HashSet<>(lotteryNumbers);
        if (uniqueSetOfNumbers.size() != LOTTERY_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }
}
