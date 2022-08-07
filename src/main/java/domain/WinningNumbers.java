package domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumbers {
    private static final int LOTTERY_NUMBER_SIZE = 6;

    private final Set<WinningNumber> winningNumbers;

    private final WinningNumber bonusNumber;

    public WinningNumbers(String winningNumbers, String bonusNumber) {
        Set<WinningNumber> lottoNumbers = convertToSet(winningNumbers);
        checkValidation(lottoNumbers);
        this.winningNumbers = lottoNumbers;

        WinningNumber bonus = convertToBall(bonusNumber);
        this.bonusNumber = bonus;
    }

    public Set<WinningNumber> getWinningNumbers() {
        return Collections.unmodifiableSet(winningNumbers);
    }

    public Rank match(LottoTicket lottoTicket) {
        int count = lottoTicket.matching(this);
        if (lottoTicket.matching(bonusNumber)) {
            return Rank.of(count, true);
        }
        return Rank.of(count, false);
    }

    private Set<WinningNumber> convertToSet(String input) {
        return Arrays.stream(input.split("\\s*,\\s*"))
                .map(Integer::parseInt)
                .map(number -> new WinningNumber(number, BallType.NORMAL))
                .collect(Collectors.toSet());
    }

    private WinningNumber convertToBall(String input) {
        return new WinningNumber(Integer.parseInt(input), BallType.BONUS);
    }

    private void checkValidation(Set<WinningNumber> lottoNumber) {
        checkSize(lottoNumber);
        checkUniqueness(lottoNumber);
    }

    private void checkSize(Set<WinningNumber> lottoNumber) {
        if (lottoNumber.size() != LOTTERY_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void checkUniqueness(Set<WinningNumber> lottoNumber) {
        Set<WinningNumber> uniqueSetOfNumbers = new HashSet<>(lottoNumber);
        if (uniqueSetOfNumbers.size() != LOTTERY_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }
}
