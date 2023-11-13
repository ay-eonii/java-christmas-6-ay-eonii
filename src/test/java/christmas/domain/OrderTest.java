package christmas.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class OrderTest {

    Order order;

    @BeforeEach
    void setUp() {
        order = new Order("해산물파스타-2,레드와인-1,초코케이크-1");
    }

    @DisplayName("할인 전 총주문 금액을 계산한다.")
    @Test
    void getTotalPrice() {
        int actual = order.getTotalPrice();

        assertThat(actual).isEqualTo(145_000);
    }

    @DisplayName("타입별 주문 수량 계산")
    @ParameterizedTest
    @CsvSource(value = {"MAIN:2", "DRINK:1", "DESSERT:1"}, delimiter = ':')
    void getAmount(Menu menu, int amount) {
        int actual = order.getAmount(menu);

        assertThat(actual).isEqualTo(amount);
    }

    @Test
    void testToString() {
    }
}