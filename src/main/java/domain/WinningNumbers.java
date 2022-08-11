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
        checkValidation(bonus);
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

    private void checkValidation(Set<LottoNumber> lottoNumbers) {
        checkSize(lottoNumbers);
        checkRedundancy(lottoNumbers);
    }

    private void checkValidation(LottoNumber bonus) {
        if (winningNumbers.contains(bonus)) {
            throw new IllegalArgumentException("로또 당첨 번호와 보너스 번호가 중복됩니다");
        }
    }

    private void checkSize(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTERY_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 당첨 번호는 6개입니다.");
        }
    }

    private void checkRedundancy(Set<LottoNumber> lottoNumbers) {
        Set<LottoNumber> uniqueSetOfNumbers = new HashSet<>(lottoNumbers);
        if (uniqueSetOfNumbers.size() != LOTTERY_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 당첨 번호는 중복될 수 없습니다.");
        }
    }
}
