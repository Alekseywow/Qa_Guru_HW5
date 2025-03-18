package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.TestData;



public class RegistrationPageObjectTests extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();





    @Test
    @Owner("Aleksey Danilov")
    @Tag("Smoke")
    void successFullRegistrationTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserEmail(testData.userEmail)
                .setGender(testData.genderWrapper)
                .setUserNumber(testData.userPhone)
                .setDateOfBrith(testData.dayOfBirth, testData.monthOfBirth, testData.yearOfBirth)
                .setSubject(testData.subject)
                .setHobbies(testData.hobby)
                .setImages(testData.picture)
                .setAddress(testData.address)
                .setState(testData.state)
                .setCity(testData.city)
                .submit();

        registrationPage.submissionCheckSuccess()
                .submissionModalMessage("Thanks for submitting the form");


        registrationPage.checkResultTablePairs("Student Name", testData.firstName + " " + testData.lastName)
                .checkResultTablePairs("Student Email", testData.userEmail)
                .checkResultTablePairs("Gender", testData.genderWrapper)
                .checkResultTablePairs("Mobile", testData.userPhone)
                .checkResultTablePairs("Date of Birth", testData.dayOfBirth + " " + testData.monthOfBirth + "," + testData.yearOfBirth)
                .checkResultTablePairs("Subjects", testData.subject)
                .checkResultTablePairs("Hobbies", testData.hobby)
                .checkResultTablePairs("Picture", testData.picture)
                .checkResultTablePairs("Address", testData.address)
                .checkResultTablePairs("State and City", testData.state + " " + testData.city);

    }

    @Test
    @Owner("Aleksey Danilov")
    @Tag("Smoke")
    void successMinimalRegistrationTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserEmail(testData.userEmail)
                .setGender(testData.genderWrapper)
                .setUserNumber(testData.userPhone)
                .submit();

        registrationPage.submissionCheckSuccess()
                .submissionModalMessage("Thanks for submitting the form");

        registrationPage.checkResultTablePairs("Student Name", testData.firstName + " " + testData.lastName)
                .checkResultTablePairs("Student Email", testData.userEmail)
                .checkResultTablePairs("Gender", testData.genderWrapper)
                .checkResultTablePairs("Mobile", testData.userPhone);
    }

    @Test
    @Owner("Aleksey Danilov")
    @Tag("Smoke")
    void negativeRegistrationTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserEmail(testData.userEmail)
                .setGender(testData.genderWrapper)
                .setUserNumber(testData.setNumberNegative)
                .submit()
                .negativeCheckResult();

    }
}
