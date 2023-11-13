package christmas.domain.benefit;

import java.util.HashMap;
import java.util.Map;

public class Events {
    private static final String CHRISTMAS = "christmasDiscount";
    private static final String WEEKDAY = "weekDayDiscount";
    private static final String WEEKEND = "weekEndDiscount";
    private static final String SPECIAL = "specialDiscount";
    private static final String PRESENTATION = "presentation";
    private final Map<String, Event> events;

    Events() {
        this.events = createEvents();
    }

    private Map<String, Event> createEvents() {
        return new HashMap<>(Map.of(
                CHRISTMAS, new ChristmasDiscount(),
                WEEKDAY, new WeekDayDiscount(),
                WEEKEND, new WeekEndDiscount(),
                SPECIAL, new SpecialDiscount(),
                PRESENTATION, new Presentation()
        ));
    }

    public Map<String, Event> getEvents() {
        return events;
    }

    public Presentation getPresentation() {
        return (Presentation) events.get(PRESENTATION);
    }
}
