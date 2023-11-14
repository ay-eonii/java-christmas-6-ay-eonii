package christmas.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

    @Test
    void readMenu() {
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}