package com.demoqa.tests;

import org.junit.jupiter.api.Test;

import javax.swing.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchTests {
    @Test
    void successfulSearchTest() {
        open("https://www.google.com/");
        $("[name=q]").setValue("selenide").pressEnter();
        $("[id=search]").shouldHave(text("Selenide"));
    }

    @Test
    void textBoxTest() {
        open("https://demoqa.com/text-box");
        $("[id=userName]").setValue("Sasha").pressEnter();
        $("[id=userEmail]").setValue("sasha@mail.ru").pressEnter();
        $("[id=currentAddress]").setValue("Omsk").pressEnter();
        $("[id=permanentAddress]").setValue("street").pressEnter();
        $("[id=submit]").click();

        $("[id=output]").shouldHave(text("Sasha"));
        $("[id=output]").shouldHave(text("sasha@mail.ru"));
        $("[id=output]").shouldHave(text("Omsk"));
        $("[id=output]").shouldHave(text("street"));
    }

}
