package christmas.domain.benefit;

import christmas.domain.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class ChristmasDiscountTest {

    ChristmasDiscount christmasDiscount;

    @BeforeEach
    void setUp() {
//        christmasDiscount = ChristmasDiscount.from();
    }

    @DisplayName("방문 날짜로 크리스마스 디데이 할인 금액을 계산한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:1000", "7:1600", "25:3400", "26:0", "31:0"}, delimiter = ':')
    void calculateBenefit(String input, int expected) {
        Date date = Date.from(input);

        christmasDiscount = new ChristmasDiscount();
        int actual = christmasDiscount.calculateBenefit(date);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("방문날짜가 25일 이전이라면 크리스마스 디데이 할인이 적용된다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "15", "25"})
    void hasDate(String input) {
        Date.from(input);
        christmasDiscount = new ChristmasDiscount();
        boolean actual = christmasDiscount.hasDate();

        assertThat(actual).isTrue();
    }

    @DisplayName("방문날짜가 25일 이후라면 크리스마스 디데이 할인이 적용되지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"26", "31"})
    void hasNotDate(String input) {
        Date.from(input);
        christmasDiscount = new ChristmasDiscount();

        boolean actual = christmasDiscount.hasDate();

        assertThat(actual).isFalse();
    }

    @DisplayName("혜택 이름을 가져온다.")
    @Test
    void getName() {
        christmasDiscount = new ChristmasDiscount();

        String actual = christmasDiscount.getName();

        assertThat(actual).isEqualTo("크리스마스 디데이 할인");
    }
}