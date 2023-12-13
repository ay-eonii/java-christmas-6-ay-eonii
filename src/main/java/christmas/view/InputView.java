package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.Date;
import christmas.domain.Order;
import christmas.exception.CustomInvalidMenuException;

import java.util.HashMap;
import java.util.Map;

public class InputView {
    private static final String INPUT_DATE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String INPUT_MENU = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";
    private static final String COMMA_SYMBOL = ",";
    private static final String HYPHEN_SYMBOL = "-";

    public Date readDate() {
        System.out.println(INPUT_DATE);
        return readDateByUser();
    }

    private Date readDateByUser() {
        try {
            String input = getWithoutSpace();
            return Date.from(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readDateByUser();
        }
    }

    public Order readMenu() {
        System.out.println(INPUT_MENU);
        return readMenuByUser();
    }

    private Order readMenuByUser() {
        String[] orders = getWithoutSpace().split(COMMA_SYMBOL);
        try {
            Map<String, Integer> menus = createMenuMap(orders);
            validateDuplication(orders, menus);
            return new Order(menus);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMenuByUser();
        }
    }

    private Map<String, Integer> createMenuMap(String[] orders) {
        Map<String, Integer> menu = new HashMap<>();
        for (String order : orders) {
            validateFormat(order);
            String[] splitWithHyphen = order.split(HYPHEN_SYMBOL);
            menu.put(splitWithHyphen[0], Integer.parseInt(splitWithHyphen[1]));
        }
        return menu;
    }

    private void validateFormat(String order) {
        if (!order.matches("^\\D+-[1-9]\\d*$")) {
            throw new CustomInvalidMenuException();
        }
    }

    private void validateDuplication(String[] split, Map<String, Integer> menu) {
        if (menu.size() != split.length) {
            throw new CustomInvalidMenuException();
        }
    }

    private String getWithoutSpace() {
        return Console.readLine().replaceAll("\\s+", "");
    }
}
