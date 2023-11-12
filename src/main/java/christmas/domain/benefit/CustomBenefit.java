package christmas.domain.benefit;

import christmas.domain.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomBenefit {
    private static final int ZERO = 0;
    private static final List<Event> benefits = new ArrayList<>(
            List.of(
                    new ChristmasDiscount(),
                    new WeekDayDiscount(),
                    new WeekEndDiscount(),
                    new SpeicalDiscount(),
                    new Presentation()
            )
    );
    private final int date;
    private final Map<Event, Integer> customBenefit;

    public CustomBenefit(int date) {
        Map<Event, Integer> customBenefit = new HashMap<>();
        for (Event benefit : benefits) {
            if (benefit.hasDate(date)) {
                customBenefit.put(benefit, ZERO);
            }
        }
        this.date = date;
        this.customBenefit = customBenefit;
    }

    public void checkBenefit(Order order) {
        customBenefit.keySet().forEach(benefit -> {
            int discount = benefit.calculateBenefit(order);
            if (benefit instanceof ChristmasDiscount) {
                discount = ((ChristmasDiscount) benefit).calculateBenefit(date);
            }
            customBenefit.put(benefit, discount);
        });
    }

}
