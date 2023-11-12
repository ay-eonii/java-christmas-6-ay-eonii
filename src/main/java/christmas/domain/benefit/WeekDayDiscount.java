package christmas.domain.benefit;

import java.util.ArrayList;
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
    public boolean hasDate(String date) {
        return this.dates.contains(date);
    }
}
