package christmas.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest extends NsTest {

    @DisplayName("유효하지 않은 날짜 입력 시 다시 입력받는다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-", "+"})
    void readInvalidDate(String input) {
        assertSimpleTest(() -> {
            runException(input);
            assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        });
    }

    @DisplayName("유효한 날짜와 공백 입력 시 공백을 무시한다.")
    @ParameterizedTest
    @CsvSource(value = {"  1:타파스-1", "1 4:타파스-1", "3  1  :타파스-1"}, delimiter = ':')
    void readDate(String date, String menu) {
        assertSimpleTest(() -> {
            run(date, menu);
            assertThat(output()).doesNotContain("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        });
    }

    @DisplayName("유효하지 않은 메뉴 입력 시 다시 입력받는다.")
    @ParameterizedTest
    @CsvSource(value = {"1:없는메뉴-1", "1:초코케이크-0", "1:초코케이크-먹고싶다", "1:좋지않은형식--", "1:초코케이크-1,초코케이크-1"}, delimiter = ':')
    void readInvalidMenu(String date, String menu) {
        assertSimpleTest(() -> {
            runException(date, menu);
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @DisplayName("유효한 메뉴와 공백 입력 시 공백을 무시한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:초코 케이크-1", "1:초코케이크 - 2", "1: 크 리 스 마 스 파 스 타 - 1"}, delimiter = ':')
    void readMenu(String date, String menu) {
        assertSimpleTest(() -> {
            runException(date, menu);
            assertThat(output()).doesNotContain("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @DisplayName("음료만 시키는 경우 다시 입력받는다.")
    @ParameterizedTest
    @CsvSource(value = {"1:제로콜라-1", "1:레드와인-2", "1:샴페인-3"}, delimiter = ':')
    void readOnlyDrinkMenu(String date, String menu) {
        assertSimpleTest(() -> {
            runException(date, menu);
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}