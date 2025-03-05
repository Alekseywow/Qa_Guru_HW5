package pages;

import com.codeborne.selenide.Modal;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendareComponent;
import pages.components.ModalComponent;
import pages.components.TableComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {  // Страница переменных

    private SelenideElement firstName = $("#firstName"),
                            lastName = $("#lastName"),
                            userEmailInput = $("#userEmail"),
                            genderWrapper = $("#genterWrapper"),
                            userNumber = $("#userNumber"),
                            dateOfBirthInput = $("#dateOfBirthInput"),
                            subjectsInput = $("#subjectsInput"),
                            hobbiesWrapper = $("#hobbiesWrapper"),
                            uploadPicture = $("#uploadPicture"),
                            currentAddress = $("#currentAddress"),
                            stateField = $("#state"),
                            stateDropdown = $("#stateCity-wrapper"),
                            cityField = $("#city"),
                            cityDropdown = $("#stateCity-wrapper"),
                            submitBtn = $("#submit");

    CalendareComponent calendareComponent = new CalendareComponent();
    ModalComponent modalComponent = new ModalComponent();
    TableComponent tableComponent = new TableComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        return this;
    }

    public RegistrationPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstName.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastName.setValue(value);

        return this;
    }

    public RegistrationPage  setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumber.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBrith(String day, String month, String year) {
        dateOfBirthInput.click();
        calendareComponent.setDate(day,month, year);

        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setImages(String value) {
        uploadPicture.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setAddress(String value) {
        currentAddress.setValue(value);

        return this;
    }

    public RegistrationPage setState(String value) {
        stateField.click();
        stateDropdown.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String value) {
        cityField.click();
        cityDropdown.$(byText(value)).click();

        return this;
    }

    public RegistrationPage submit() {
        submitBtn.click();

        return this;
    }

    public RegistrationPage submissionCheckSuccess() {
        modalComponent.isVisible();
        return this;
    }

    public RegistrationPage negativeCheckResult() {
        modalComponent.isHidden();

        return this;
    }

    public RegistrationPage submissionModalMessage(String value) {
        modalComponent.getTitle(value);

        return this;
    }

    public RegistrationPage checkResultTablePairs(String key, String value) {
        tableComponent.getCellValueByKey(key, value);

        return this;
    }

}
