package christmas.domain.benefit;

import christmas.domain.Date;
import christmas.domain.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class SpecialDiscountTest {

    SpecialDiscount specialDiscount;

    @BeforeEach
    void setUp() {
        specialDiscount = new SpecialDiscount();
    }

    @DisplayName("일요일, 크리스마스에 특별할인을 진행한다.")
    @ParameterizedTest
    @ValueSource(strings = {"3", "10", "17", "24", "25", "31"})
    void hasDate(String input) {
        Date date = Date.of(input);
        boolean actual = specialDiscount.hasDate(date);

        assertThat(actual).isTrue();
    }

    @DisplayName("일요일, 크리스마스를 제외한 날에는 특별할인을 진행하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "4", "5", "6", "7", "8", "9", "11", "12", "13", "14", "15", "16", "18", "19", "20", "21", "22", "23", "26", "27", "28", "29", "30"})
    void hasNotDate(String input) {
        Date date = Date.of(input);
        boolean actual = specialDiscount.hasDate(date);

        assertThat(actual).isFalse();
    }

    @DisplayName("특별 할인 혜택은 1000원이다.")
    @Test
    void calculateBenefit() {
        Order order = mock(Order.class);
        int actual = specialDiscount.calculateBenefit(order);

        assertThat(actual).isEqualTo(1000);
    }

    @Test
    void getName() {
        String actual = specialDiscount.getName();

        assertThat(actual).isEqualTo("특별 할인");
    }
}