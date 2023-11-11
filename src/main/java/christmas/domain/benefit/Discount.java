package christmas.domain.benefit;

public abstract class Discount extends Benefit {
    abstract boolean hasDate(String date);
}
