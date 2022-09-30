package com.demoqa.data;

import com.github.javafaker.Faker;
import java.util.Locale;

public class UserData {

    private static final Faker faker = new Faker(new Locale("en"));
public static String
    name = faker.name().firstName(),
    lastName = faker.name().lastName(),
    userEmail = lastName.toLowerCase() + faker.internet().emailAddress(),
    userNumber = faker.phoneNumber().subscriberNumber(10),
    hobby = "Sports",
    gender = faker.demographic().sex(),
    subject = "Maths",
    currentAddress = faker.address().fullAddress(),
    state = "Uttar Pradesh",
    city = "Agra",
    date = String.valueOf(faker.number().numberBetween(10, 28)),
    picturePath = "src/test/resources/nature.jpeg",
    month = "April",
    year = String.valueOf(faker.number().numberBetween(1900, 2005));
}