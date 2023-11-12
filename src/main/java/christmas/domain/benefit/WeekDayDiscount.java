package christmas.domain.benefit;

import christmas.domain.Menu;
import christmas.domain.Order;

import java.util.List;

import static java.time.DayOfWeek.*;

public class WeekDayDiscount extends Discount {

    public WeekDayDiscount() {
        super(List.of(SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY));
    }

    @Override
    public boolean hasDate(int date) {
        return super.hasDate(date);
    }

    @Override
    public int calculateBenefit(Order order) {
        int amount = order.getAmount(Menu.DESSERT);
        return amount * 2023;
    }
}
