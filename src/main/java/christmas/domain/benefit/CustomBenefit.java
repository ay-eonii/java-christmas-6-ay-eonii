package christmas.domain.benefit;

import christmas.domain.Date;
import christmas.domain.Order;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static christmas.domain.benefit.Event.ZERO;

public class CustomBenefit extends Events {
    private static final String FORMAT = "%s: -%s원\n";
    private static final String NONE = "없음\n";
    private final Map<Event, Integer> customBenefit;
    private final Date date;
    private final DecimalFormat decimalFormat = new DecimalFormat("#,##0");

    public CustomBenefit(Date date) {
        this.date = date;
        this.customBenefit = initCustomBenefit(date);
    }

    private Map<Event, Integer> initCustomBenefit(Date date) {
        Map<Event, Integer> customBenefit = new HashMap<>();
        getEvents().forEach((name, event) -> {
            if (event.hasDate(date)) {
                customBenefit.put(event, ZERO);
            }
        });
        return customBenefit;
    }

    public void checkBenefit(Order order) {
        if (order.isUnderMinPrice()) {
            return;
        }
        customBenefit.keySet().forEach(event -> {
            int benefit = event.calculateBenefit(order);
            if (event instanceof ChristmasDiscount) {
                benefit = ((ChristmasDiscount) event).calculateBenefit(date);
            }
            customBenefit.put(event, benefit);
        });
    }

    public String getPresentation(Order order) {
        return getPresentation().getMenu(order);
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
                .filter(benefit -> benefit.getValue() != ZERO)
                .map(benefit -> String.format(FORMAT, benefit.getKey().getName(), decimalFormat.format(benefit.getValue())))
                .collect(Collectors.joining());
    }
}
