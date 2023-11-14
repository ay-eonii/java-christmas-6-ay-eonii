package christmas.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.Application;
import christmas.exception.CustomInvalidDateException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class DateTest extends NsTest {

    @DisplayName("유효하지 않은 날짜의 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "32", "1a"})
    void of(String input) {
        assertThatExceptionOfType(CustomInvalidDateException.class)
                .isThrownBy(() -> Date.of(input))
                .withMessageMatching(".*\\[ERROR\\] 유효하지 않은 날짜입니다\\. 다시 입력해 주세요\\..*");
    }

    @DisplayName("크리스마스 이전인지 확인한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "15", "25"})
    void isBeforeChristmas(String input) {
        Date date = Date.of(input);
        boolean actual = date.isBeforeChristmas();

        assertThat(actual).isTrue();
    }

    @DisplayName("크리스마스 이후인지 확인한다.")
    @ParameterizedTest
    @ValueSource(strings = {"26", "31"})
    void isAfterChristmas(String input) {
        Date date = Date.of(input);
        boolean actual = date.isBeforeChristmas();

        assertThat(actual).isFalse();
    }

    @Test
    void isChristmas() {
    }

    @Test
    void getDate() {
    }

    @Test
    void getDayOfWeek() {
    }

    @Test
    void testToString() {
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}