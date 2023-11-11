package christmas.domain.benefit;

import java.util.ArrayList;
import java.util.List;

public class WeekDayDiscount extends Discount {
    private final List<String> dates = new ArrayList<>(List.of("3", "4", "5", "6", "7", "10", "22", "12", "13", "14", "17", "18", "19", "20", "21", "24", "25", "26", "27", "28", "31"));

    @Override
    public boolean hasDate(String date) {
        return this.dates.contains(date);
    }
}
