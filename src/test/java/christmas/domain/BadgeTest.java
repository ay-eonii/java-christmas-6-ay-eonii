package christmas.domain;

import christmas.domain.benefit.CustomBenefit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BadgeTest {

    @DisplayName("혜택 금액 별 배지를 결정한다.")
    @ParameterizedTest
    @CsvSource(value = {"20000:산타", "10000:트리", "5000:별", "4999:없음"}, delimiter = ':')
    void determineBadge(int totalBenefit, String badge) {
        CustomBenefit customBenefit = mock(CustomBenefit.class);

        when(customBenefit.getTotalBenefit()).thenReturn(totalBenefit);
        String actual = Badge.determineBadge(customBenefit);

        assertThat(actual).isEqualTo(badge);
    }
}