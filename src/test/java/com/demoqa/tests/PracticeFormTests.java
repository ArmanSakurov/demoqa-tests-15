package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.PracticeFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.demoqa.data.UserData;

public class PracticeFormTests {
    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTests() {

        practiceFormPage.openPage("/automation-practice-form")
                .setFirstName(UserData.name)
                .setLastName(UserData.lastName)
                .setUserEmail(UserData.userEmail)
                .setGenter(UserData.gender)
                .setPhoneNumber(UserData.userNumber)
                .setBirthDate(UserData.date, UserData.month, UserData.year)
                .setSubject(UserData.subject)
                .setHobbies(UserData.hobby)
                .setPicture(UserData.picturePath)
                .setAddress(UserData.currentAddress, UserData.state, UserData.city)
                .clickSubmit();

        practiceFormPage.checkResultsTableVisible()
                .checkResult("Student Name", UserData.name + " " + UserData.lastName)
                .checkResult("Student Email", UserData.userEmail)
                .checkResult("Gender", UserData.gender)
                .checkResult("Mobile", UserData.userNumber)
                .checkResult("Date of Birth", UserData.date + " " + UserData.month + "," + UserData.year)
                .checkResult("Subjects", UserData.subject)
                .checkResult("Hobbies", UserData.hobby)
                .checkResult("Picture", "nature.jpeg")
                .checkResult("Address", UserData.currentAddress)
                .checkResult("State and City", UserData.state + " " + UserData.city);
    }
}
