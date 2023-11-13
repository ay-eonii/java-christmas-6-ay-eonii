package christmas.domain.benefit;

import christmas.domain.Order;

public class Presentation implements Event {
    private static final String NAME = "증정 이벤트";
    private static final String NONE = "없음";
    private static final int ZERO = 0;
    private static final int STANDARD = 120_000;
    private static final String PRESENTATION_MENU = "샴페인 1개";
    private static final int VALUE = 25_000;

    public String getPresentationMenu(Order order) {
        if (hasPresentation(order)) {
            return PRESENTATION_MENU;
        }
        return NONE;
    }

    private boolean hasPresentation(Order order) {
        return order.getTotalPrice() >= STANDARD;
    }

    @Override
    public boolean hasDate(int date) {
        return true;
    }

    @Override
    public int calculateBenefit(Order order) {
        if (hasPresentation(order)) {
            return VALUE;
        }
        return ZERO;
    }

    @Override
    public String getName() {
        return NAME;
    }
}
