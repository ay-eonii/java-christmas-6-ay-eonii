package christmas.domain.benefit;

import christmas.domain.Date;
import christmas.domain.Order;

public interface Event {
    int ZERO = 0;

    boolean hasDate(Date date);

    int calculateBenefit(Order order);

    String getName();
}
