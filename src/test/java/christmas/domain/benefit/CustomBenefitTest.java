package christmas.domain.benefit;

import christmas.domain.Date;
import christmas.domain.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class CustomBenefitTest {
    CustomBenefit customBenefit;
    Order order;

    @BeforeEach
    void setUp() {
        Date date = Date.of("3");
        customBenefit = new CustomBenefit(date);
        Map<String, Integer> menus = new HashMap<>(Map.of("해산물파스타", 2, "레드와인", 1, "초코케이크", 1));
        order = new Order(menus, date);
    }

    @DisplayName("혜택을 계산한다.")
    @Test
    void checkBenefit() {
        customBenefit.checkBenefit(order);

        String result = customBenefit.toString();
        assertThat(result).contains(
                "평일 할인: -2023원",
                "크리스마스 디데이 할인: -1200원",
                "증정 이벤트: -25000원",
                "특별 할인: -1000원"
        );
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

    @DisplayName("혜택 내역을 출력한다.")
    @Test
    void testToString() {
        String result = customBenefit.toString();

        assertThat(result).isEqualTo("없음\n");
    }
}