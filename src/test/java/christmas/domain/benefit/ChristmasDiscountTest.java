package christmas.domain.benefit;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ChristmasDiscountTest {

    ChristmasDiscount christmasDiscount;

    @BeforeEach
    void setUp() {
        christmasDiscount = new ChristmasDiscount();
    }

    @DisplayName("방문 날짜로 크리스마스 디데이 할인 금액을 계산한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:1000", "7:1600", "25:3400", "26:0", "31:0"}, delimiter = ':')
    void calculateBenefit(int date, int expected) {
        int actual = christmasDiscount.calculateBenefit(date);

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void hasDate() {
    }

    @Test
    void getName() {
    }
}