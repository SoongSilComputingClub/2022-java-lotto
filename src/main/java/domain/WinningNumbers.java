package domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumbers {
    private static final int LOTTERY_NUMBER_SIZE = 6;

    private final Set<LottoNumber> winningNumbers;

    private final LottoNumber bonusNumber;

    public WinningNumbers(String winningNumbers, String bonusNumber) {
        Set<LottoNumber> lottoNumbers = convertToSet(winningNumbers);
        checkValidation(lottoNumbers);
        this.winningNumbers = lottoNumbers;

        LottoNumber bonus = convertToBall(bonusNumber);
        this.bonusNumber = bonus;
    }

    public Set<LottoNumber> getWinningNumbers() {
        return Collections.unmodifiableSet(winningNumbers);
    }

    public Rank getRank(LottoTicket lottoTicket) {
        int count = (int) winningNumbers.stream()
                .filter(lottoTicket::contains)
                .count();
        boolean hasBonus = lottoTicket.contains(bonusNumber);
        return Rank.of(count, hasBonus);
    }

    private Set<LottoNumber> convertToSet(String input) {
        return Arrays.stream(input.split("\\s*,\\s*"))
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }

    private LottoNumber convertToBall(String input) {
        return new LottoNumber(Integer.parseInt(input));
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
