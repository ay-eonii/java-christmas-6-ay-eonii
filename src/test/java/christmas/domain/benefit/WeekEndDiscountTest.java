package christmas.domain.benefit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class WeekEndDiscountTest {

    WeekEndDiscount weekEndDiscount;

    @BeforeEach
    void setUp() {
        weekEndDiscount = new WeekEndDiscount();
    }

    @DisplayName("금,토에 주말 할인을 진행한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 8, 9, 15, 16, 22, 23, 29, 30})
    void hasDate(int date) {
        boolean actual = weekEndDiscount.hasDate(date);

        assertThat(actual).isTrue();
    }

    @DisplayName("일, 월, 화, 수, 목에 주말 할인을 진행하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6, 7, 10, 11, 12, 13, 14, 17, 18, 19, 20, 21, 24, 25, 26, 27, 28, 31})
    void hasNotDate(int date) {
        boolean actual = weekEndDiscount.hasDate(date);

        assertThat(actual).isFalse();
    }

    @Test
    void calculateBenefit() {
    }

    @Test
    void getName() {
    }
}