package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTests() {
        String name = "TestName";
        String lastName = "TestLastName";
        String userEmail = lastName + "@gmail.com";
        String userNumber = "9222314562";
        String hobby = "Sports";
        String gender = "Male";
        String subject = "Maths";
        String currentAddress = "TestCurrentAddress";
        String state = "Uttar Pradesh";
        String city = "Agra";

        open("/automation-practice-form");
        $("#firstName").setValue(name);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(userNumber);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1900");
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__day--019").click();

        $("#subjectsInput").setValue(subject).pressEnter();
        $("#hobbiesWrapper").$(byText(hobby)).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/nature.jpeg"));
        $("#currentAddress").setValue(currentAddress);

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $("#state").click();
        $("#state").$(byText(state)).click();
        $("#city").click();
        $("#city").$(byText(city)).click();

        $("#submit").click();

        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".table").shouldHave(text(name + " " + lastName));
        $(".table").shouldHave(text(userEmail));
        $(".table").shouldHave(text(gender));
        $(".table").shouldHave(text(userNumber));
        $(".table").shouldHave(text("19 April,1900"));
        $(".table").shouldHave(text(subject));
        $(".table").shouldHave(text(hobby));
        $(".table").shouldHave(text("nature.jpeg"));
        $(".table").shouldHave(text(currentAddress));
        $(".table").shouldHave(text(state + " " + city));
    }
}
