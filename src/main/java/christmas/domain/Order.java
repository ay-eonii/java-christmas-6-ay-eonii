package christmas.domain;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private static final String FORMAT = "%s %d개\n";
    private Map<String, Integer> order;
    private Map<Menu, Integer> typeOrder;

    public Order(String input) {
        Map<String, Integer> order = new HashMap<>();
        Map<Menu, Integer> typeOrder = new HashMap<>();
        String[] bills = input.split(",");
        for (String bill : bills) {
            String[] split = bill.split("-");
            String name = split[0];
            int amount = Integer.parseInt(split[1]);

            Menu menu = Menu.findType(name);
            typeOrder.put(menu, amount);
            order.put(name, amount);
        }
        this.order = order;
        this.typeOrder = typeOrder;
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (String menu : order.keySet()) {
            totalPrice += Menu.getPrice(menu) * order.get(menu);
        }
        return totalPrice;
    }

    public int getAmount(Menu menu) {
        if (typeOrder.containsKey(menu)) {
            return typeOrder.get(menu);
        }
        return 0;
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
