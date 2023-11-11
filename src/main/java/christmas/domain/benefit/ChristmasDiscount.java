package christmas.domain.benefit;

public class ChristmasDiscount extends Discount {
    private final int date = 25;

    @Override
    public boolean hasDate(String date) {
        return Integer.parseInt(date) <= this.date;
    }
}
