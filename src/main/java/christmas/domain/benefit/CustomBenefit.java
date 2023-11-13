package christmas.domain.benefit;

import christmas.domain.Order;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CustomBenefit {
    private static final int ZERO = 0;
    private static final String FORMAT = "%s: -%d원\n";
    private final int date;
    private final Events events;
    private final Map<Event, Integer> customBenefit;

    public CustomBenefit(int date) {
        this.date = date;
        this.events = new Events();
        this.customBenefit = initCustomBenefit(date);
    }

    private Map<Event, Integer> initCustomBenefit(int date) {
        Map<Event, Integer> customBenefit = new HashMap<>();
        for (Event event : events.getEvents().values()) {
            if (event.hasDate(date)) {
                customBenefit.put(event, ZERO);
            }
        }
        return customBenefit;
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
        return events.getPresentation().getPresentationMenu(order);
    }

    public int getTotalBenefit() {
        return customBenefit.values().stream().mapToInt(Integer::intValue).sum();
    }

    public int getExpectedPay(Order order) {
        int presentationBenefit = customBenefit.get(events.getPresentation());
        return order.getTotalPrice() - getTotalBenefit() + presentationBenefit;
    }

    @Override
    public String toString() {

        return customBenefit.entrySet()
                .stream()
                .filter(benefit -> benefit.getValue() != 0)
                .map(benefit -> String.format(FORMAT, benefit.getKey().getName(), benefit.getValue()))
                .collect(Collectors.joining());
    }
}
