package christmas.exception;

public class CustomInvalidMenuException extends IllegalArgumentException {
    public CustomInvalidMenuException() {
        super("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }
}
