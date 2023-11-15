package christmas.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class OrderTest {

    Order order;

    @BeforeEach
    void setUp() {
        Map<String, Integer> menus = new HashMap<>(Map.of("해산물파스타", 2, "레드와인", 1, "초코케이크", 1));
        order = new Order(menus);
    }

    @DisplayName("최소 금액 이하인지 확인한다.")
    @Test
    void isUnderMinPrice() {
        Order order = mock(Order.class);
        when(order.getTotalPrice()).thenReturn(9999);
        when(order.isUnderMinPrice()).thenCallRealMethod();

        boolean actual = order.isUnderMinPrice();

        Assertions.assertThat(actual).isTrue();
    }

    @DisplayName("할인 전 총주문 금액을 계산한다.")
    @Test
    void getTotalPrice() {
        int actual = order.getTotalPrice();

        assertThat(actual).isEqualTo(145_000);
    }

    @DisplayName("타입별 주문 수량을 계산한다.")
    @ParameterizedTest
    @CsvSource(value = {"MAIN:2", "DRINK:1", "DESSERT:1"}, delimiter = ':')
    void getAmount(Menu menu, int amount) {
        int actual = order.getAmount(menu);

        assertThat(actual).isEqualTo(amount);
    }

    @DisplayName("주문 내역을 출력한다.")
    @Test
    void testToString() {
        String result = order.toString();

        assertThat(result).contains(
                "해산물파스타 2개",
                "레드와인 1개",
                "초코케이크 1개"
        );
    }
}