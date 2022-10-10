package com.demoqa.pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class QaToolsMainPage {

    public QaToolsMainPage openPage(String url, String buttonTitle) {
        open(url);
        $x("//*[@class=\"group-header\"]//*[contains(text(), '" + buttonTitle + "' )]").should(appear);
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public QaToolsMainPage clickLeftMenuTitle (String buttonTitle) {
        $x("//*[@class=\"group-header\"]//*[contains(text(), '" + buttonTitle + "' )]").click();

        return this;
    }
}
