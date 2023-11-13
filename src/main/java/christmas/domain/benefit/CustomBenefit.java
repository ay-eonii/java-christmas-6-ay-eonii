package christmas.domain.benefit;

import christmas.domain.Order;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CustomBenefit extends Events {
    private static final int ZERO = 0;
    private static final String FORMAT = "%s: -%d원\n";
    private static final String NONE = "없음\n";
    private final int date;
    private final Map<Event, Integer> customBenefit;

    public CustomBenefit(int date) {
        this.date = date;
        this.customBenefit = initCustomBenefit(date);
    }

    private Map<Event, Integer> initCustomBenefit(int date) {
        Map<Event, Integer> customBenefit = new HashMap<>();
        getEvents().forEach((name, event) -> {
            if (event.hasDate(date)) {
                customBenefit.put(event, ZERO);
            }
        });
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
        return getPresentation().getPresentationMenu(order);
    }

    public int getTotalBenefit() {
        return customBenefit.values().stream().mapToInt(Integer::intValue).sum();
    }

    public int getExpectedPay(Order order) {
        int presentationBenefit = customBenefit.get(getPresentation());
        return order.getTotalPrice() - getTotalBenefit() + presentationBenefit;
    }

    @Override
    public String toString() {
        if (getTotalBenefit() == ZERO) {
            return NONE;
        }
        return customBenefit.entrySet()
                .stream()
                .filter(benefit -> benefit.getValue() != 0)
                .map(benefit -> String.format(FORMAT, benefit.getKey().getName(), benefit.getValue()))
                .collect(Collectors.joining());
    }
}
