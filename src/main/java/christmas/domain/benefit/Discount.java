package christmas.domain.benefit;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public abstract class Discount implements Event {
    private final List<DayOfWeek> day;

    protected Discount(List<DayOfWeek> day) {
        this.day = day;
    }

    public boolean hasDate(int date) {
        LocalDate localDate = LocalDate.of(2023, Month.DECEMBER, date);
        return day.contains(localDate.getDayOfWeek());
    }
}
