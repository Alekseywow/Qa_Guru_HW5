package pages;

import com.codeborne.selenide.Modal;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
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

    @Step("Открываем страницу ")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        return this;
    }
    @Step("Удаляем баннеры")
    public RegistrationPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }
    @Step("Вводим имя")
    public RegistrationPage setFirstName(String value) {
        firstName.setValue(value);

        return this;
    }
    @Step("Вводим Фамилию")
    public RegistrationPage setLastName(String value) {
        lastName.setValue(value);

        return this;
    }
    @Step("Вводим Емейл")
    public RegistrationPage  setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }
    @Step("Выбираем пол")
    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }
    @Step("Вводим номер телефона")
    public RegistrationPage setUserNumber(String value) {
        userNumber.setValue(value);

        return this;
    }
    @Step("Вводим дату рождения")
    public RegistrationPage setDateOfBrith(String day, String month, String year) {
        dateOfBirthInput.click();
        calendareComponent.setDate(day,month, year);

        return this;
    }
    @Step("Выбираем субъект")
    public RegistrationPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }
    @Step("Выбираем хобби")
    public RegistrationPage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }
    @Step("Вставляем изображение")
    public RegistrationPage setImages(String value) {
        uploadPicture.uploadFromClasspath(value);

        return this;
    }
    @Step("Вводим адрес")
    public RegistrationPage setAddress(String value) {
        currentAddress.setValue(value);

        return this;
    }
    @Step("Вводим штат")
    public RegistrationPage setState(String value) {
        stateField.click();
        stateDropdown.$(byText(value)).click();

        return this;
    }
    @Step("Вводим город")
    public RegistrationPage setCity(String value) {
        cityField.click();
        cityDropdown.$(byText(value)).click();

        return this;
    }
    @Step("Кликаем по кнопке")
    public RegistrationPage submit() {
        submitBtn.click();

        return this;
    }
    @Step("Проверяем окно успеха")
    public RegistrationPage submissionCheckSuccess() {
        modalComponent.isVisible();
        return this;
    }
    @Step("Проверяем что окно успеха отсутствует")
    public RegistrationPage negativeCheckResult() {
        modalComponent.isHidden();

        return this;
    }
    @Step("Проверяем что присутствует сообщение об успехе")
    public RegistrationPage submissionModalMessage(String value) {
        modalComponent.getTitle(value);

        return this;
    }
    @Step("Проверяем что присутствуе окно с результатами")
    public RegistrationPage checkResultTablePairs(String key, String value) {
        tableComponent.getCellValueByKey(key, value);

        return this;
    }

}
