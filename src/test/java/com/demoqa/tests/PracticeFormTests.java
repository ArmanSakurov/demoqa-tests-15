package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.PracticeFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
        String date = "19";
        String month = "April";
        String year = "1900";

        practiceFormPage.openPage("/automation-practice-form")
                .setFirstName(name)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGenter(gender)
                .setPhoneNumber(userNumber)
                .setBirthDate(date, month, year)
                .setSubject(subject)
                .setHobbies(hobby)
                .setPicture("src/test/resources/nature.jpeg")
                .setAddress(currentAddress, state, city)
                .clickSubmit();

        practiceFormPage.checkResultsTableVisible()
                .checkResult("Student Name", name + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", date + " " + month + "," + year)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobby)
                .checkResult("Picture", "nature.jpeg")
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state + " " + city);
    }
}
