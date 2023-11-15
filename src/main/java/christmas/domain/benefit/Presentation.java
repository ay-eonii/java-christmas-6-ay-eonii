package christmas.domain.benefit;

import christmas.domain.Menu;
import christmas.domain.Order;

import java.time.DayOfWeek;
import java.util.List;

public class Presentation extends Discount {
    private static final String NAME = "증정 이벤트";
    private static final String NONE = "없음";
    private static final int ZERO = 0;
    private static final int STANDARD = 120_000;
    public static final String MENU = "샴페인";
    private static final int AMOUNT = 1;
    public static final String FORMAT = "%s %d개";

    protected Presentation() {
        super(List.of(DayOfWeek.values()));
    }

    public String getMenu(Order order) {
        if (hasPresentation(order)) {
            return String.format(FORMAT, MENU, AMOUNT);
        }
        return NONE;
    }

    boolean hasPresentation(Order order) {
        return order.getTotalPrice() >= STANDARD;
    }

    @Override
    public int calculateBenefit(Order order) {
        if (hasPresentation(order)) {
            return Menu.getPrice(MENU);
        }
        return ZERO;
    }

    @Override
    public String getName() {
        return NAME;
    }
}
