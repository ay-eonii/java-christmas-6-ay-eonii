package christmas.domain.benefit;

import christmas.domain.Order;

import java.util.List;

import static java.time.DayOfWeek.SUNDAY;

public class SpeicalDiscount extends Discount {
    private final int CHRISTMAS_DAY = 25;

    public SpeicalDiscount() {
        super(List.of(SUNDAY));
    }

    @Override
    public boolean hasDate(int date) {
        return super.hasDate(date) || date == CHRISTMAS_DAY;
    }

    @Override
    public int calculateBenefit(Order order) {
        return 1000;
    }
}
