package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MenuTest {

    @DisplayName("메뉴 타입을 찾는다.")
    @ParameterizedTest
    @CsvSource(value = {"양송이수프:APPETIZER", "타파스:APPETIZER", "시저샐러드:APPETIZER",
            "티본스테이크:MAIN", "바비큐립:MAIN", "해산물파스타:MAIN", "크리스마스파스타:MAIN",
            "초코케이크:DESSERT", "아이스크림:DESSERT",
            "제로콜라:DRINK", "레드와인:DRINK", "샴페인:DRINK"}, delimiter = ':')
    void findType(String input, String type) {
        Menu actual = Menu.findType(input);
        assertThat(actual.name()).isEqualTo(type);
    }

    @Test
    void getPrice() {
    }

    @Test
    void values() {
    }

    @Test
    void valueOf() {
    }
}