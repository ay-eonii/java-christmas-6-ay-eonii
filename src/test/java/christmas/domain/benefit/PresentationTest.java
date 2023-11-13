package christmas.domain.benefit;

import christmas.domain.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PresentationTest {

    Presentation presentation;

    @BeforeEach
    void setUp() {
        presentation = new Presentation();
    }

    @DisplayName("할인 전 총주문 금액이 120,000원 이상이면 샴페인 1개를 증정한다.")
    @ParameterizedTest
    @ValueSource(ints = {120_000, 150_000_000})
    void getPresentationMenu(int totalPrice) {
        Order order = mock(Order.class);
        when(order.getTotalPrice()).thenReturn(totalPrice);

        String actual = presentation.getMenu(order);

        Assertions.assertEquals(actual, "샴페인 1개");
    }

    @DisplayName("할인 전 총주문 금액이 120,000원 이하면 증정 이벤트에 해당하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 119_999})
    void getNonePresentationMenu(int totalPrice) {
        Order order = mock(Order.class);
        when(order.getTotalPrice()).thenReturn(totalPrice);

        String actual = presentation.getMenu(order);

        Assertions.assertEquals(actual, "없음");
    }

    @Test
    void hasDate() {
    }

    @Test
    void calculateBenefit() {
    }

    @Test
    void getName() {
    }
}