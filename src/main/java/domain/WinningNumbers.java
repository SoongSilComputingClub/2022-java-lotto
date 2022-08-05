package domain;

import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class WinningNumbers {
    private static final int LOTTERY_NUMBER_SIZE = 6;

    private final List<Integer> winningNumbers;

    public WinningNumbers(String input) {
        List<Integer> lottoNumber = convertToList(input);
        checkValidation(lottoNumber);
        this.winningNumbers = lottoNumber;
    }

    public List<Integer> getWinningNumbers() {
        return Collections.unmodifiableList(winningNumbers);
    }

    public Rank match(LottoTicket lottoTicket) {
        return Rank.of(lottoTicket.matching(this));
    }

    private List<Integer> convertToList(String input) {
        return Arrays.stream(input.split("\\s*,\\s*"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void checkValidation(List<Integer> lottoNumber) {
        checkSize(lottoNumber);
        checkUniqueness(lottoNumber);
    }

    private void checkSize(List<Integer> lottoNumber) {
        if (lottoNumber.size() != LOTTERY_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void checkUniqueness(List<Integer> lottoNumber) {
        Set<Integer> uniqueSetOfNumbers = new HashSet<>(lottoNumber);
        if (uniqueSetOfNumbers.size() != LOTTERY_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }
}
