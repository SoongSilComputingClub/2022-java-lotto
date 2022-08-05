package domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumbers {
    private static final int LOTTERY_NUMBER_SIZE = 6;

    private final Set<LottoNumber> winningNumbers;

    public WinningNumbers(String input) {
        Set<LottoNumber> lottoNumber = convertToSet(input);
        checkValidation(lottoNumber);
        this.winningNumbers = lottoNumber;
    }

    public Set<LottoNumber> getWinningNumbers() {
        return Collections.unmodifiableSet(winningNumbers);
    }

    public Rank match(LottoTicket lottoTicket) {
        return Rank.of(lottoTicket.matching(this));
    }

    private Set<LottoNumber> convertToSet(String input) {
        return Arrays.stream(input.split("\\s*,\\s*"))
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }

    private void checkValidation(Set<LottoNumber> lottoNumber) {
        checkSize(lottoNumber);
        checkUniqueness(lottoNumber);
    }

    private void checkSize(Set<LottoNumber> lottoNumber) {
        if (lottoNumber.size() != LOTTERY_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void checkUniqueness(Set<LottoNumber> lottoNumber) {
        Set<LottoNumber> uniqueSetOfNumbers = new HashSet<>(lottoNumber);
        if (uniqueSetOfNumbers.size() != LOTTERY_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }
}
