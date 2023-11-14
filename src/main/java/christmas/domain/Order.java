package christmas.domain;

import christmas.exception.CustomInvalidMenuException;

import java.util.Map;

public class Order {
    private static final String FORMAT = "%s %d개\n";
    private Map<String, Integer> order;

    public Order(Map<String, Integer> order) {
        validateOrder(order);
        order.keySet().forEach(Menu::findType);
        this.order = order;
    }

    private void validateOrder(Map<String, Integer> order) {
        long drinkCount = getDrinkCount(order);
        if (drinkCount == order.size()) {
            throw new CustomInvalidMenuException();
        }
    }

    private long getDrinkCount(Map<String, Integer> order) {
        return order.keySet().stream()
                .map(Menu::findType)
                .filter(menu -> menu == Menu.DRINK)
                .count();
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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        order.forEach((menu, amount) ->
                stringBuilder.append(String.format(FORMAT, menu, amount))
        );
        return stringBuilder.toString();
    }
}
