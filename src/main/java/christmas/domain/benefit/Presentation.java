package christmas.domain.benefit;

import christmas.domain.Order;

public class Presentation implements Event {

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

}
