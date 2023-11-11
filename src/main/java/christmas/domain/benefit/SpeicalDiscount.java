package christmas.domain.benefit;

import java.util.ArrayList;
import java.util.List;

public class SpeicalDiscount extends Discount {
    private final List<String> dates = new ArrayList<>(List.of("3", "10", "17", "24", "25", "31"));

    @Override
    public boolean hasDate(String date) {
        return this.dates.contains(date);
    }
}
