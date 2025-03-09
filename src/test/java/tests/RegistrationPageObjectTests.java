package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;



public class RegistrationPageObjectTests extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successFullRegistrationTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName("Aleksey")
                .setLastName("Alla")
                .setUserEmail("asd@re.ru")
                .setGender("Male")
                .setUserNumber("1231231231")
                .setDateOfBrith("26","September", "1994")
                .setSubject("English")
                .setHobbies("Sports")
                .setImages("images_2.jpg")
                .setAddress("asda")
                .setState("NCR")
                .setCity("Delhi")
                .submit();

        registrationPage.submissionCheckSuccess()
                .submissionModalMessage("Thanks for submitting the form");


        registrationPage.checkResultTablePairs("Student Name", "Aleksey Alla")
                .checkResultTablePairs("Student Email", "asd@re.ru")
                .checkResultTablePairs("Gender", "Male")
                .checkResultTablePairs("Mobile", "1231231231")
                .checkResultTablePairs("Date of Birth", "26 September,1994")
                .checkResultTablePairs("Subjects", "English")
                .checkResultTablePairs("Hobbies", "Sports")
                .checkResultTablePairs("Picture", "images_2.jpg")
                .checkResultTablePairs("Address", "asda")
                .checkResultTablePairs("State and City", "NCR Delhi");

    }

    @Test
    void successMinimalRegistrationTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName("Aleksey")
                .setLastName("Alla")
                .setUserEmail("asd@re.ru")
                .setGender("Male")
                .setUserNumber("1231231231")
                .submit();

        registrationPage.submissionCheckSuccess()
                .submissionModalMessage("Thanks for submitting the form");

        registrationPage.checkResultTablePairs("Student Name", "Aleksey Alla")
                .checkResultTablePairs("Student Email", "asd@re.ru")
                .checkResultTablePairs("Gender", "Male")
                .checkResultTablePairs("Mobile", "1231231231");
    }

    @Test
    void negativeRegistrationTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName("Aleksey")
                .setLastName("Alla")
                .setUserEmail("asd@re.ru")
                .setGender("Male")
                .setUserNumber("444")
                .submit()
                .negativeCheckResult();



    }



}
