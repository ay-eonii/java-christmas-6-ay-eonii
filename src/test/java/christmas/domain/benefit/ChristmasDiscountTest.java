package christmas.domain.benefit;

import christmas.domain.Date;
import christmas.domain.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ChristmasDiscountTest {

    ChristmasDiscount christmasDiscount;

    @BeforeEach
    void setUp() {
        christmasDiscount = new ChristmasDiscount();
    }

    @DisplayName("방문 날짜로 크리스마스 디데이 할인 금액을 계산한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:1000", "7:1600", "25:3400", "26:0", "31:0"}, delimiter = ':')
    void calculateBenefit(String input, int expected) {
        Order order = mock(Order.class);
        Date date = Date.of(input);
        when(order.getDate()).thenReturn(date);

        int actual = christmasDiscount.calculateBenefit(order);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("방문날짜가 25일 이전이라면 크리스마스 디데이 할인이 적용된다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "15", "25"})
    void hasDate(String input) {
        Date date = Date.of(input);
        boolean actual = christmasDiscount.hasDate(date);

        assertThat(actual).isTrue();
    }

    @DisplayName("방문날짜가 25일 이후라면 크리스마스 디데이 할인이 적용되지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"26", "31"})
    void hasNotDate(String input) {
        Date date = Date.of(input);
        boolean actual = christmasDiscount.hasDate(date);

        assertThat(actual).isFalse();
    }

    @Test
    void getName() {
        String actual = christmasDiscount.getName();

        assertThat(actual).isEqualTo("크리스마스 디데이 할인");
    }
}