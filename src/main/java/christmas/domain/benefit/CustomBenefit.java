package christmas.domain.benefit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomBenefit {
    private static final int ZERO = 0;
    private static final List<Benefit> benefits = new ArrayList<>(
            List.of(
                    new ChristmasDiscount(),
                    new WeekDayDiscount(),
                    new WeekEndDiscount(),
                    new SpeicalDiscount(),
                    new Presentation()
            )
    );
    private final Map<Benefit, Integer> customBenefit;

    public CustomBenefit(String date) {
        Map<Benefit, Integer> customBenefit = new HashMap<>();
        for (Benefit benefit : benefits) {
            if (benefit.hasDate(date)) {
                customBenefit.put(benefit, ZERO);
            }
        }
        this.customBenefit = customBenefit;
    }
}
