package com.demoqa.tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import com.demoqa.data.MenuTitles;
import com.demoqa.pages.QaToolsMainPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class DemoQaToolsTests {
    QaToolsMainPage qaToolsMainPage = new QaToolsMainPage();

    String formsButton = "Forms";
    String widgetsButton = "Widgets";
    String automationPracticeFormUrl = "/automation-practice-form";


    static Stream<Arguments> qaToolsMainPageMenuChaptersDataProvider() {
        return Stream.of(
                Arguments.of(List.of("Text Box", "Check Box", "Radio Button", "Web Tables", "Buttons", "Links", "Broken Links - Images", "Upload and Download", "Dynamic Properties"), MenuTitles.Elements),
                Arguments.of(List.of("Practice Form"), MenuTitles.Forms)
        );
    }

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @ValueSource(strings = {"Elements", "Forms", "Alerts", "Widgets", "Interactions", "Application",})
    @ParameterizedTest(name = "Проверка отображения пункта меню: {0}")
    void checkMenuTitlesWithValueSourceAnnotation(String testData) {
        qaToolsMainPage.openPage("/widgets", widgetsButton);
        $x("//*[@class=\"group-header\"]//*[contains(text(), '" + testData + "' )]").shouldBe(visible);
    }

    @ParameterizedTest(name = "Проверка отображения пунктов меню для раздела {0}")
    @CsvSource(value = {
            "Forms, Practice Form",
            "Elements, Check Box",
            "Alerts, Frames",
            "Widgets, Accordian",
            "Interactions, Sortable",
            "Application, Login"
    })
    void checkMenuChapters(String menuTitle, String menuChapters) {
        qaToolsMainPage.openPage("/widgets", widgetsButton)
                .clickLeftMenuTitle(widgetsButton)
                .clickLeftMenuTitle(menuTitle);
        $$(".text").findBy(text(menuChapters)).shouldBe(visible);
    }

    @MethodSource("qaToolsMainPageMenuChaptersDataProvider")
    @ParameterizedTest(name = "Проверка отображения страниц раздела: {1}")
    void checkQaToolsMainPageMenuChapters(List<String> menuChapters, MenuTitles menuTitles) {
        qaToolsMainPage.openPage(automationPracticeFormUrl, formsButton)
                .clickLeftMenuTitle("Forms")
                .clickLeftMenuTitle(menuTitles.name());
        $$(".text").filter(visible)
                .shouldHave(CollectionCondition.texts(menuChapters));
    }

    @EnumSource(MenuTitles.class)
    @ParameterizedTest()
    void checkMenuTitles(MenuTitles menuTitles) {
        qaToolsMainPage.openPage(automationPracticeFormUrl, formsButton);
        $x("//*[@class=\"group-header\"]//*[contains(text(), '" + menuTitles + "' )]").shouldBe(visible);
    }
}
