package christmas.domain.benefit;

import java.util.ArrayList;
import java.util.List;

public class WeekEndDiscount extends Discount {
    private final List<String> dates = new ArrayList<>(List.of("1", "2", "8", "9", "15", "16", "22", "23", "29", "30"));

    @Override
    public boolean hasDate(String date) {
        return this.dates.contains(date);
    }
}
