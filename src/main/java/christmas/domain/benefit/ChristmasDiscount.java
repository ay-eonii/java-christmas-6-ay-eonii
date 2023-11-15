package christmas.domain.benefit;

import christmas.domain.Date;
import christmas.domain.Order;

import java.time.DayOfWeek;
import java.util.List;

public class ChristmasDiscount extends Discount {
    private static final String NAME = "크리스마스 디데이 할인";
    private static final int UNIT = 100;
    private static final int DEFAULT = 1000;

    public ChristmasDiscount() {
        super(List.of(DayOfWeek.values()));
    }

    public int calculateBenefit(Date date) {
        if (date.isBeforeChristmas()) {
            return (date.getDate() - 1) * UNIT + DEFAULT;
        }
        return ZERO;
    }

    @Override
    public boolean hasDate(Date date) {
        return super.hasDate(date) && date.isBeforeChristmas();
    }

    @Override
    public int calculateBenefit(Order order) {
        return ZERO;
    }

    @Override
    public String getName() {
        return NAME;
    }
}
