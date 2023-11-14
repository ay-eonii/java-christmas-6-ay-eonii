package christmas.domain.benefit;

import christmas.domain.Date;
import christmas.domain.Order;

public interface Event {
    boolean hasDate(Date date);

    int calculateBenefit(Order order);

    String getName();
}
