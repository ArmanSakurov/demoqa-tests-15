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

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void DifferentInputFieldsTest() {
        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $("[id=firstName]").setValue("Sasha");
        $("[id=lastName]").setValue("Alex");
        $("[id=userEmail]").setValue("sasha@mail.ru");
        $("[id=genterWrapper]").click();
        $("[id=userNumber]").setValue("9998883333");
        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__year-select").selectOption("2021");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__day--019").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#currentAddress").setValue("Saint-P");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click();
        $(".table-responsive table").$(byText("Student Name")).parent().shouldHave(text("Sasha Alex"));
        $(".table-responsive table").$(byText("Student Email")).parent().shouldHave(text("sasha@mail.ru"));
        $(".table-responsive table").$(byText("Gender")).parent().shouldHave(text("Female"));
        $(".table-responsive table").$(byText("Mobile")).parent().shouldHave(text("9998883333"));
        $(".table-responsive table").$(byText("Date of Birth")).parent().shouldHave(text("19 January,2021"));
        $(".table-responsive table").$(byText("Subjects")).parent().shouldHave(text("Maths"));
        $(".table-responsive table").$(byText("Hobbies")).parent().shouldHave(text("Sports"));
        $(".table-responsive table").$(byText("Address")).parent().shouldHave(text("Saint-P"));
        $(".table-responsive table").$(byText("State and City")).parent().shouldHave(text("NCR Delhi"));
    }
}

