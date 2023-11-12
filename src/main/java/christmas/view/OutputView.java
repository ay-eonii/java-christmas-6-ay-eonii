package christmas.view;

public class OutputView {
    private static final String WELCOME = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String PREVIEW = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String TOTAL_PRICE = "<할인 전 총주문 금액>\n%d원";

    public void printWelcome() {
        System.out.println(WELCOME);
    }

    public void printPreview() {
        System.out.println(PREVIEW);
    }

    public void printOrder(String order) {
        System.out.println(order);
    }

    public void printTotalPrice(int totalPrice) {
        System.out.println(String.format(TOTAL_PRICE, totalPrice));
    }
}
