package christmas.domain;

import java.util.Map;

public class Order {
    private static final String FORMAT = "%s %d개\n";
    private Map<String, Integer> order;

    public Order(Map<String, Integer> order) {
        order.keySet().forEach(Menu::findType);
        this.order = order;
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
