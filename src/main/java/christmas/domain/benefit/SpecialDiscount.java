package christmas.domain.benefit;

import christmas.domain.Order;

import java.util.List;

import static java.time.DayOfWeek.SUNDAY;

public class SpecialDiscount extends Discount {
    private static final String NAME = "특별 할인";
    private final int CHRISTMAS_DAY = 25;

    public SpecialDiscount() {
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

    @Override
    public String getName() {
        return NAME;
    }
}
