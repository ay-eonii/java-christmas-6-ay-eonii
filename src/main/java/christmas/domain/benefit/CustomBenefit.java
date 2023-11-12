package christmas.domain.benefit;

import christmas.domain.Order;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CustomBenefit {
    private static final int ZERO = 0;
    private final ChristmasDiscount christmasDiscount = new ChristmasDiscount();
    private final WeekDayDiscount weekDayDiscount = new WeekDayDiscount();
    private final WeekEndDiscount weekEndDiscount = new WeekEndDiscount();
    private final SpeicalDiscount speicalDiscount = new SpeicalDiscount();
    private final Presentation presentation = new Presentation();
    private final List<Event> benefits = new LinkedList<>(
            List.of(
                    christmasDiscount,
                    weekDayDiscount,
                    weekEndDiscount,
                    speicalDiscount,
                    presentation
            )
    );
    private static final String FORMAT = "%s: -%d원\n";
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
        customBenefit.keySet().forEach(event -> {
            int benefit = event.calculateBenefit(order);
            if (event instanceof ChristmasDiscount) {
                benefit = ((ChristmasDiscount) event).calculateBenefit(date);
            }
            customBenefit.put(event, benefit);
        });
    }

    public String getPresentation(Order order) {
        return presentation.getPresentation(order);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        customBenefit.forEach((benefit, price) -> {
            stringBuilder.append(String.format(FORMAT, benefit.toString(), price));
        });
        return stringBuilder.toString();
    }
}
