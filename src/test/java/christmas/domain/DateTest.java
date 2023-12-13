package christmas.domain;

import christmas.exception.CustomInvalidDateException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class DateTest {

    @DisplayName("유효하지 않은 날짜의 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "32", "1a"})
    void of(String input) {
        assertThatExceptionOfType(CustomInvalidDateException.class)
                .isThrownBy(() -> Date.from(input))
                .withMessageMatching(".*\\[ERROR\\] 유효하지 않은 날짜입니다\\. 다시 입력해 주세요\\..*");
    }

    @DisplayName("크리스마스 이전인지 확인한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "15", "25"})
    void isBeforeChristmas(String input) {
        Date date = Date.from(input);
        boolean actual = date.isBeforeChristmas();

        assertThat(actual).isTrue();
    }

    @DisplayName("크리스마스 이후인지 확인한다.")
    @ParameterizedTest
    @ValueSource(strings = {"26", "31"})
    void isAfterChristmas(String input) {
        Date date = Date.from(input);
        boolean actual = date.isBeforeChristmas();

        assertThat(actual).isFalse();
    }

    @DisplayName("크리스마스인지 확인한다.")
    @Test
    void isChristmas() {
        Date date = Date.from("25");
        boolean actual = date.isChristmas();

        assertThat(actual).isTrue();
    }

    @DisplayName("크리스마스가 아닌지 확인한다.")
    @ParameterizedTest
    @ValueSource(strings = {"26", "31"})
    void isNotChristmas(String input) {
        Date date = Date.from(input);
        boolean actual = date.isChristmas();

        assertThat(actual).isFalse();
    }
}