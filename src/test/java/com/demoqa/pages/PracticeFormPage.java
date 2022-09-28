package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.AddressComponent;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultsTableComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {

    private CalendarComponent calendarComponent = new CalendarComponent();
    private AddressComponent addressComponent = new AddressComponent();
    private ResultsTableComponent resultsTableComponent = new ResultsTableComponent();

    public SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName");


    public PracticeFormPage openPage(String url) {
        open(url);
        $(".practice-form-wrapper").shouldHave(text("Student registration"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public PracticeFormPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public PracticeFormPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public PracticeFormPage setUserEmail(String value) {
        $("#userEmail").setValue(value);

        return this;
    }

    public PracticeFormPage setGenter(String value) {
        $("#genterWrapper").$(byText(value)).click();

        return this;
    }

    public PracticeFormPage setPhoneNumber(String value) {
        $("#userNumber").setValue(value);

        return this;
    }

    public PracticeFormPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public PracticeFormPage setAddress(String address, String state, String city) {
        addressComponent.setAddress(address, state, city);

        return this;
    }

    public PracticeFormPage checkResultsTableVisible() {
        resultsTableComponent.checkVisible();

        return this;
    }

    public PracticeFormPage checkResult(String key, String value) {
        resultsTableComponent.checkResult(key, value);

        return this;
    }

    public PracticeFormPage setSubject(String value) {
        $("#subjectsInput").setValue(value).pressEnter();

        return this;
    }

    public PracticeFormPage setHobbies(String value) {
        $("#hobbiesWrapper").$(byText(value)).click();

        return this;
    }

    public PracticeFormPage setPicture(String value) {
        $("#uploadPicture").uploadFile(new File(value));

        return this;
    }

    public PracticeFormPage clickSubmit () {
        $("#submit").click();

        return this;
    }
}
