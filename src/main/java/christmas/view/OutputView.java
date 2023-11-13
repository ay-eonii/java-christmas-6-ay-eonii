package christmas.view;

public class OutputView {
    private static final String WELCOME = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String PREVIEW = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n";
    private static final String ORDER = "<주문 메뉴>";
    private static final String TOTAL_PRICE = "<할인 전 총주문 금액>\n%d원\n";
    private static final String PRESENTATION_MENU = "<증정 메뉴>\n%s\n";
    private static final String BENEFIT_LIST = "<혜택내역>\n%s";
    private static final String TOTAL_BENEFIT = "<총 혜택 금액>\n%d원\n";
    private static final String EXPECTED_PAY = "<할인 후 예상 결제 금액>\n%d원\n";
    private static final String BADGE = "<12월 이벤트 배지>\n%s";

    public void printWelcome() {
        System.out.println(WELCOME);
    }

    public void printPreview(int date) {
        System.out.println(String.format(PREVIEW, date));
    }

    public void printOrder(String order) {
        System.out.println(ORDER);
        System.out.println(order);
    }

    public void printTotalPrice(int totalPrice) {
        System.out.println(String.format(TOTAL_PRICE, totalPrice));
    }

    public void printPresentation(String presentation) {
        System.out.println(String.format(PRESENTATION_MENU, presentation));
    }

    public void printBenefit(String benefit) {
        System.out.println(String.format(BENEFIT_LIST, benefit));
    }

    public void printTotalBenefit(int totalBenefit) {
        System.out.println(String.format(TOTAL_BENEFIT, totalBenefit * -1));
    }

    public void printExpectedPay(int expectedPay) {
        System.out.println(String.format(EXPECTED_PAY, expectedPay));
    }

    public void printBadge(String badge) {
        System.out.println(String.format(BADGE, badge));
    }
}
