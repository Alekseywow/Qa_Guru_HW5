package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ModalComponent {  // Здесь вынесли другие компоненты

    public void isVisible(){
        $(".modal-dialog").shouldBe(visible);  // Модельное окно для проверки присутствует
    }

    public void isHidden() {
        $(".modal-dialog").shouldNotBe(visible); // Модельное окно для проверки отсутствует
    }

    public void getTitle(String value) {
        $(".modal-header .modal-title").shouldHave(text(value)); // Проверка на название модельного окна
    }

}
