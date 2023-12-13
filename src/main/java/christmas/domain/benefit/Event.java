package christmas.domain.benefit;

import christmas.domain.Order;

public interface Event {
    int ZERO = 0;

    boolean hasDate();

    int calculateBenefit(Order order);

    String getName();
}
