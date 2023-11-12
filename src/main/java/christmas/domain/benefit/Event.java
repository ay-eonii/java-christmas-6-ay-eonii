package christmas.domain.benefit;

import christmas.domain.Order;

public interface Event {
    boolean hasDate(int date);

    int calculateBenefit(Order order);
}
