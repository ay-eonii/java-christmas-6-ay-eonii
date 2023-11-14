package christmas.domain.benefit;

import christmas.domain.Order;

import java.time.DayOfWeek;
import java.util.List;

public class Presentation extends Discount {
    private static final String NAME = "증정 이벤트";
    private static final String NONE = "없음";
    private static final int ZERO = 0;
    private static final int STANDARD = 120_000;
    public static final String MENU = "샴페인";
    private static final String AMOUNT = "1개";
    private static final int VALUE = 25_000;

    protected Presentation() {
        super(List.of(DayOfWeek.values()));
    }

    public String getMenu(Order order) {
        if (hasPresentation(order)) {
            return String.join(" ", MENU, AMOUNT);
        }
        return NONE;
    }

    boolean hasPresentation(Order order) {
        return order.getTotalPrice() >= STANDARD;
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
