package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {

    public SelenideElement userNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            outputInfo = $("#output");

    public TextBoxPage openPage(String url) {
        open(url);
        $(".main-header").shouldHave(text("Text Box"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public TextBoxPage setUserName(String value) {
        userNameInput.setValue(value);

        return this;
    }

    public TextBoxPage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        permanentAddressInput.setValue(value);

        return this;
    }

    public TextBoxPage clickSubmit () {
        $("#submit").click();

        return this;
    }

    public TextBoxPage checkResults(String value) {
        outputInfo.should(appear);
        outputInfo.shouldHave(text(value));

        return this;
    }
}
