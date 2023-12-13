package christmas.domain.benefit;

import christmas.domain.Menu;
import christmas.domain.Order;

import java.util.List;

import static java.time.DayOfWeek.*;

public class WeekDayDiscount extends Discount {
    private static final String NAME = "평일 할인";
    private static final int UNIT = 2023;

    public WeekDayDiscount() {
        super(List.of(SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY));
    }

    @Override
    public boolean hasDate() {
        return super.hasDate();
    }

    @Override
    public int calculateBenefit(Order order) {
        int amount = order.getAmount(Menu.DESSERT);
        return amount * UNIT;
    }

    @Override
    public String getName() {
        return NAME;
    }
}
