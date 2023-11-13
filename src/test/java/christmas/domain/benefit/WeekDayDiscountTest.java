package christmas.domain.benefit;

import christmas.domain.Menu;
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

class WeekDayDiscountTest {

    WeekDayDiscount weekDayDiscount;

    @BeforeEach
    void setUp() {
        weekDayDiscount = new WeekDayDiscount();
    }

    @DisplayName("일,월,화,수,목에 평일할인을 진행한다.")
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6, 7, 10, 11, 12, 13, 14, 17, 18, 19, 20, 21, 24, 25, 26, 27, 28, 31})
    void hasDate(int date) {
        boolean actual = weekDayDiscount.hasDate(date);

        assertThat(actual).isTrue();
    }

    @DisplayName("금,토에 평일할인을 진행하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 8, 9, 15, 16, 22, 23, 29, 30})
    void hasNotDate(int date) {
        boolean actual = weekDayDiscount.hasDate(date);

        assertThat(actual).isFalse();
    }

    @DisplayName("평일 할인 금액을 계산한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:2023", "2:4046", "1061534:2147483282"}, delimiter = ':')
    void calculateBenefit(int amount, int benefit) {
        Order order = mock(Order.class);
        Menu dessert = Menu.DESSERT;

        when(order.getAmount(dessert)).thenReturn(amount);
        int actual = weekDayDiscount.calculateBenefit(order);

        assertThat(actual).isEqualTo(benefit);
    }

    @Test
    void getName() {
        String actual = weekDayDiscount.getName();

        assertThat(actual).isEqualTo("평일 할인");
    }
}