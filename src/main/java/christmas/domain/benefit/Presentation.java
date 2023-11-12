package christmas.domain.benefit;

public class Presentation implements Event {

    @Override
    public boolean hasDate(int date) {
        return true;
    }
}
