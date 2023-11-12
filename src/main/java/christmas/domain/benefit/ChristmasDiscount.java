package christmas.domain.benefit;

import java.time.DayOfWeek;
import java.util.List;

public class ChristmasDiscount extends Discount {
    private final int date = 25;

    public ChristmasDiscount() {
        super(List.of(DayOfWeek.values()));
    }

    @Override
    public boolean hasDate(int date) {
        return super.hasDate(date) && date <= this.date;
    }
}
