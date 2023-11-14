package christmas.domain.benefit;

import christmas.domain.Date;
import christmas.domain.Order;

import java.time.DayOfWeek;
import java.util.List;

public abstract class Discount implements Event {
    private final List<DayOfWeek> day;

    protected Discount(List<DayOfWeek> day) {
        this.day = day;
    }

    public boolean hasDate(Date date) {
        return day.contains(date.getDayOfWeek());
    }

    public abstract int calculateBenefit(Order order);
}
