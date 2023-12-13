package christmas.domain;

import christmas.exception.CustomInvalidDateException;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class Date {
    private static final int START_DAY = 1;
    private static final int END_DAY = 31;
    private static final int CHRISTMAS_DAY = 25;
    private static final int YEAR = 2023;
    private final int date;
    private static Date instance;

    private Date(int date) {
        this.date = date;
    }

    public static Date from(String input) {
        try {
            int date = Integer.parseInt(input);
            validateDate(date);
            instance = new Date(date);
            return instance;
        } catch (NumberFormatException e) {
            throw new CustomInvalidDateException();
        }
    }

    public static Date getInstance() {
        assert (instance != null);
        return instance;
    }

    private static void validateDate(int date) {
        if (date < START_DAY || date > END_DAY) {
            throw new CustomInvalidDateException();
        }
    }

    public boolean isBeforeChristmas() {
        return this.date <= CHRISTMAS_DAY;
    }

    public boolean isChristmas() {
        return this.date == CHRISTMAS_DAY;
    }

    public int getDate() {
        return this.date;
    }

    public DayOfWeek getDayOfWeek() {
        return LocalDate.of(YEAR, Month.DECEMBER, date).getDayOfWeek();
    }

    @Override
    public String toString() {
        return String.valueOf(this.date);
    }
}
