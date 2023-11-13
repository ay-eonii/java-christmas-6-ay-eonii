package christmas.domain.benefit;

import christmas.domain.Order;

import java.time.DayOfWeek;
import java.util.List;

public class ChristmasDiscount extends Discount {
    private static final String NAME = "크리스마스 디데이 할인";
    private final int date = 25;

    public ChristmasDiscount() {
        super(List.of(DayOfWeek.values()));
    }

    public int calculateBenefit(int date) {
        return (date - 1) * 100 + 1000;
    }

    @Override
    public boolean hasDate(int date) {
        return super.hasDate(date) && date <= this.date;
    }

    @Override
    public int calculateBenefit(Order order) {
        return 0;
    }

    @Override
    public String getName() {
        return NAME;
    }
}
