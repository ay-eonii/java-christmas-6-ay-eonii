package christmas.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    void getAmount() {
    }

    @Test
    void testToString() {
    }
}