package christmas.domain.benefit;

import christmas.domain.Menu;
import christmas.domain.Order;

import java.util.List;

import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.SATURDAY;

public class WeekEndDiscount extends Discount {

    public WeekEndDiscount() {
        super(List.of(FRIDAY, SATURDAY));
    }

    @Override
    public boolean hasDate(int date) {
        return super.hasDate(date);
    }

    @Override
    public int calculateBenefit(Order order) {
        return order.getAmount(Menu.MAIN) * 2023;
    }
}
