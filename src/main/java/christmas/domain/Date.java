package christmas.domain;

import christmas.exception.CustomInvalidDateException;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class Date {
    private static final int CHRISTMAS_DAY = 25;
    private final int date;

    private Date(int date) {
        this.date = date;
    }

    public static Date of(String input) {
        try {
            int date = Integer.parseInt(input);
            if (date < 1 || date > 31) {
                throw new CustomInvalidDateException();
            }
            return new Date(date);
        } catch (NumberFormatException e) {
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
        return LocalDate.of(2023, Month.DECEMBER, date).getDayOfWeek();
    }

    @Override
    public String toString() {
        return String.valueOf(this.date);
    }
}
