package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.data.UserData;
import com.demoqa.pages.TextBoxPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TextBoxWithMethodsTests {
    TextBoxPage textBoxPage = new TextBoxPage();

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void textBoxTest() {
        textBoxPage.openPage("https://demoqa.com/text-box")
                .setUserName(UserData.name)
                .setUserEmail(UserData.userEmail)
                .setCurrentAddress(UserData.currentAddress)
                .setPermanentAddress(UserData.currentAddress)
                .clickSubmit();

        textBoxPage.checkResults(UserData.name)
                .checkResults(UserData.userEmail)
                .checkResults(UserData.currentAddress)
                .checkResults(UserData.currentAddress);
    }
}
