package christmas.domain;

import christmas.domain.benefit.Presentation;
import christmas.exception.CustomInvalidMenuException;

import java.util.Map;

public class Order {
    private static final int MAX_ORDER = 20;
    private static final String FORMAT = "%s %d개\n";
    private Map<String, Integer> order;

    public Order(Map<String, Integer> order) {
        validateOrder(order);
        this.order = order;
    }

    private void validateOrder(Map<String, Integer> order) {
        long drinkCount = getDrinkCount(order);
        if (drinkCount == order.size()) {
            throw new CustomInvalidMenuException();
        }
        validateMax(order);
    }

    private long getDrinkCount(Map<String, Integer> order) {
        return order.keySet().stream()
                .map(Menu::findType)
                .filter(menu -> menu == Menu.DRINK)
                .count();
    }

    private void validateMax(Map<String, Integer> order) {
        int orderCount = order.values().stream().mapToInt(Integer::intValue).sum();
        if (orderCount > MAX_ORDER) {
            throw new CustomInvalidMenuException();
        }
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (String menu : order.keySet()) {
            totalPrice += Menu.getPrice(menu) * order.get(menu);
        }
        return totalPrice;
    }

    public int getAmount(Menu menu) {
        return order.keySet().stream()
                .filter(food -> Menu.findType(food) == menu)
                .mapToInt(amount -> order.get(amount))
                .sum();
    }

    public boolean hasChampagne() {
        return order.containsKey(Presentation.MENU);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        order.forEach((menu, amount) ->
                stringBuilder.append(String.format(FORMAT, menu, amount))
        );
        return stringBuilder.toString();
    }
}
