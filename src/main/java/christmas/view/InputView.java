package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.Date;

public class InputView {
    private static final String INPUT_DATE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String INPUT_MENU = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";

    public Date readDate() {
        System.out.println(INPUT_DATE);
        return readDateByUser();
    }

    private Date readDateByUser() {
        try {
            String withoutSpace = Console.readLine().replaceAll("\\s+", "");
            return Date.of(withoutSpace);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readDateByUser();
        }
    }

    public String readMenu() {
        System.out.println(INPUT_MENU);
        return Console.readLine();
    }
}
