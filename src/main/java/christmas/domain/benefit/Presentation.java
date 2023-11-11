package christmas.domain.benefit;

public class Presentation extends Benefit {
    @Override
    boolean hasDate(String date) {
        return true;
    }
}
