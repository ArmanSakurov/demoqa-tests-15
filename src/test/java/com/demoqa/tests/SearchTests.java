package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SearchTests {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void successfulSearchTest() {
        open("https://www.google.com/");
        $("[name=q]").setValue("selenide").pressEnter();
        $("[id=search]").shouldHave(text("Selenide: лаконичные и стабильные"));
    }

    @Test
    void textBoxTest() {
        open("https://demoqa.com/text-box");
        $("[id=userName]").setValue("Sasha");
        $("[id=userEmail]").setValue("sasha@mail.ru");
        $("[id=currentAddress]").setValue("Omsk");
        $("[id=permanentAddress]").setValue("street");
        $("[id=submit]").click();

        $("[id=output]").shouldHave(text("Sasha"));
        $("[id=output]").shouldHave(text("sasha@mail.ru"));
        $("[id=output]").shouldHave(text("Omsk"));
        $("[id=output]").shouldHave(text("street"));
    }
}
