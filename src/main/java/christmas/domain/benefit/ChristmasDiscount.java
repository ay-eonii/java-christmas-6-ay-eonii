package christmas.domain.benefit;

import christmas.domain.Date;
import christmas.domain.Order;

import java.time.DayOfWeek;
import java.util.List;

public class ChristmasDiscount extends Discount {
    private static final String NAME = "크리스마스 디데이 할인";

    public ChristmasDiscount() {
        super(List.of(DayOfWeek.values()));
    }

    @Override
    public boolean hasDate(Date date) {
        return super.hasDate(date) && date.isBeforeChristmas();
    }

    @Override
    public int calculateBenefit(Order order) {
        if (order.getDate().isBeforeChristmas()) {
            return (order.getDate().getDate() - 1) * 100 + 1000;
        }
        return 0;
    }

    @Override
    public String getName() {
        return NAME;
    }
}
