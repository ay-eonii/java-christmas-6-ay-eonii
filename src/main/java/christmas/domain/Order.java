package christmas.domain;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private static final String FORMAT = "%s %d개\n";
    private Map<String, Integer> order;
    private Date date;

    public Order(String input, Date date) {
        Map<String, Integer> order = new HashMap<>();
        String[] bills = input.split(",");

        for (String bill : bills) {
            String[] split = bill.split("-");
            String name = split[0];
            int amount = Integer.parseInt(split[1]);
            order.put(name, amount);
        }
        this.date = date;
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

    public Date getDate() {
        return date;
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
