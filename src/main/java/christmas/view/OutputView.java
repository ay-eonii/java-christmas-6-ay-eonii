package christmas.view;

public class OutputView {
    private static final String WELCOME = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String PREVIEW = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";

    public void printWelcome() {
        System.out.println(WELCOME);
    }

    public void printPreview() {
        System.out.println(PREVIEW);
    }
}
