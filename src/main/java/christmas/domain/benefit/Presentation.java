package christmas.domain.benefit;

import christmas.domain.Order;

public class Presentation implements Event {
    private static final String NAME = "증정 이벤트";
    private static final String PRESENTATION_MENU = "샴페인 1개";
    private static final String NONE = "없음";

    @Override
    public boolean hasDate(int date) {
        return true;
    }

    public int calculateBenefit(Order order) {
        if (hasPresentation(order)) {
            return 25_000;
        }
        return 0;
    }

    private boolean hasPresentation(Order order) {
        return order.getTotalPrice() >= 120_000;
    }

    public String getPresentation(Order order) {
        if (hasPresentation(order)) {
            return PRESENTATION_MENU;
        }
        return NONE;
    }

    @Override
    public String toString() {
        return NAME;
    }
}
