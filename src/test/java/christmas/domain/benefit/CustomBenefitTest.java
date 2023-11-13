package christmas.domain.benefit;

import christmas.domain.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CustomBenefitTest {
    CustomBenefit customBenefit;
    Order order;

    @BeforeEach
    void setUp() {
        customBenefit = new CustomBenefit(3);
        order = new Order("해산물파스타-2,레드와인-1,초코케이크-1");
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

    @Test
    void getExpectedPay() {
    }

    @Test
    void testToString() {
    }
}