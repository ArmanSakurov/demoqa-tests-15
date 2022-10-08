package com.demoqa.tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import com.demoqa.data.Locale;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class JUnitDemoTest {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = false;
    }

    @DisplayName("JUnit demo test")
    @Test
    void simpleTestFirst() {
        System.out.println("### @Test simpleTestFirst() !");
        Assertions.assertTrue(3 > 2);
    }


    //ТЕСТОВЫЕ ДАННЫЕ: ["Selenide", "JUnit"]
    @ValueSource(strings = {"Selenide", "JUnit"})
    @ParameterizedTest(name = "Проверка числа результатов поиска в Яндексе для запроса {0}")
        // [test_data] == (String testData)
    void yandexSearchCommonTest(String testData) {
        open("https://ya.ru");
        $("#text").setValue(testData);
        $("button[type='submit']").click();
        $$("li.serp-item")
                .shouldHave(CollectionCondition.size(10))
                .first()
                .shouldHave(text(testData));
    }

    @CsvSource({
            "Selenide, Selenide - это фреймворк для автоматизированного тестировани",
            "JUnit, В этом туториале по JUnit 5 рассказывается о том"
    })
    @ParameterizedTest(name = "Проверка числа результатов поиска в Яндексе для запроса {0}")
    void yandexSearchCommonTestdifferentExpectedText(String searchQuery, String expectedText) {
        open("https://ya.ru");
        $("#text").setValue(searchQuery);
        $("button[type='submit']").click();
        $$("li.serp-item")
                .shouldHave(CollectionCondition.size(10))
                .first()
                .shouldHave(text(expectedText));
    }

    static Stream<Arguments> selenideSiteButtonsText() {
        return Stream.of(
                Arguments.of(Locale.EN, List.of("Quick start", "Docs", "FAQ", "Blog", "Javadoc", "Users", "Quotes")),
                Arguments.of(Locale.RU, List.of("С чего начать?", "Док", "ЧАВО", "Блог", "Javadoc", "Пользователи", "Отзывы"))
        );
    }

    @MethodSource("selenideSiteButtonsText")
    @ParameterizedTest(name = "Проверка отображения названия кнопок для локали: {0}")
    void selenideSiteButtonsText(Locale locale, List<String> buttonsTexts) {
        open("https://selenide.org/");
        $$("#languages a").find(text(locale.name())).click();
        $$(".main-menu-pages a").filter(visible)
                .shouldHave(CollectionCondition.texts(buttonsTexts));
    }

    @EnumSource(Locale.class)
    @ParameterizedTest(name = "Проверка отображения локали: {0}")
    void checkLocaleTest(Locale locale) {
        open("https://selenide.org/");
        $$("#languages a").find(text(locale.name())).shouldBe(visible);
    }

}
