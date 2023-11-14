package christmas.domain.benefit;

import christmas.domain.Date;
import christmas.domain.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CustomBenefitTest {
    CustomBenefit customBenefit;
    Order order;

    @BeforeEach
    void setUp() {
        customBenefit = new CustomBenefit(Date.of("3"));
        Map<String, Integer> menus = new HashMap<>(Map.of("해산물파스타", 2, "레드와인", 1, "초코케이크", 1));
        order = new Order(menus);
    }

    @DisplayName("혜택을 계산한다.")
    @Test
    void checkBenefit() {
        customBenefit.checkBenefit(order);

        String result = customBenefit.toString();
        assertThat(result).contains(
                "평일 할인: -2,023원",
                "크리스마스 디데이 할인: -1,200원",
                "증정 이벤트: -25,000원",
                "특별 할인: -1,000원"
        );
    }

    @DisplayName("총 주문 금액이 10,000원 미만라면 혜택이 적용되지 않는다.")
    @Test
    void checkBenefitWithUnderMinPrice() {
        Order order = mock(Order.class);
        when(order.getTotalPrice()).thenReturn(9999);

        customBenefit.checkBenefit(order);

        String result = customBenefit.toString();
        assertThat(result).contains("없음");
    }

    @DisplayName("증정 메뉴를 확인한다.")
    @Test
    void getPresentation() {
        String actual = customBenefit.getPresentation(order);

        assertThat(actual).isEqualTo("샴페인 1개");
    }

    @DisplayName("총혜택 금액을 계산한다.")
    @Test
    void getTotalBenefit() {
        customBenefit.checkBenefit(order);
        int actual = customBenefit.getTotalBenefit();

        assertThat(actual).isEqualTo(29223);
    }

    @DisplayName("예상 결제 금액을 계산한다.")
    @Test
    void getExpectedPay() {
        customBenefit.checkBenefit(order);
        int actual = customBenefit.getExpectedPay(order);

        assertThat(actual).isEqualTo(140777);
    }

    @DisplayName("할인 전 총주문 금액이 12만 원 이상이고 샴페인을 주문한 경우 예상 결제 금액에서 샴페인 1개 가격을 제외한다.")
    @Test
    void getExpectedPayWithoutOneChampagne() {
        Map<String, Integer> menus = new HashMap<>(Map.of("해산물파스타", 2, "레드와인", 1, "샴페인", 2));
        order = new Order(menus);

        customBenefit.checkBenefit(order);
        int actual = customBenefit.getExpectedPay(order);

        assertThat(actual).isEqualTo(152800);
    }

    @DisplayName("혜택 내역을 출력한다.")
    @Test
    void testToString() {
        String result = customBenefit.toString();

        assertThat(result).isEqualTo("없음\n");
    }
}