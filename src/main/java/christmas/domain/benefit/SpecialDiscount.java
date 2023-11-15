package christmas.domain.benefit;

import christmas.domain.Date;
import christmas.domain.Order;

import java.util.List;

import static java.time.DayOfWeek.SUNDAY;

public class SpecialDiscount extends Discount {
    private static final String NAME = "특별 할인";
    private static final int DEFAULT = 1000;

    public SpecialDiscount() {
        super(List.of(SUNDAY));
    }

    @Override
    public boolean hasDate(Date date) {
        return super.hasDate(date) || date.isChristmas();
    }

    @Override
    public int calculateBenefit(Order order) {
        return DEFAULT;
    }

    @Override
    public String getName() {
        return NAME;
    }
}
