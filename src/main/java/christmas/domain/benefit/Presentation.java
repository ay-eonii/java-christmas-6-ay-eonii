package christmas.domain.benefit;

import christmas.domain.Order;

public class Presentation implements Event {
    private static final String NAME = "증정 이벤트";

    @Override
    public boolean hasDate(int date) {
        return true;
    }

    public int calculateBenefit(Order order) {
        if (order.getTotalPrice() >= 120_000) {
            return 25_000;
        }
        return 0;
    }

    @Override
    public String toString() {
        return NAME;
    }
}
