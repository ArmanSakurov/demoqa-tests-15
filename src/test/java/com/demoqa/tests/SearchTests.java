package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchTests {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void successfulSearchTest() {
        open("https://www.google.com/");
        $("[name=q]").setValue("selenide").pressEnter();
        $("[id=search]").shouldHave(text("Selenide"));
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

    @Test
    void DifferentInputFieldsTest() {
        open("https://demoqa.com/automation-practice-form");
        $("[id=firstName]").setValue("Sasha");
        $("[id=lastName]").setValue("Alex");
        $("[id=userEmail]").setValue("sasha@mail.ru");
        $("[id=genterWrapper]").click();
        $("[id=userNumber]").setValue("+79819999999");
        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__year-select").selectOption("2022");
        $(".react-datepicker__month-select").selectOption("November");
        $(".react-datepicker__day react-datepicker__day--003 react-datepicker__day--selected").click();






    }

}

