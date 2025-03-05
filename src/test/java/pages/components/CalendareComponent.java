package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendareComponent {  // Тут вынесли класс для календаря, создали под нее конкретную переменную setDate

    public void setDate(String day, String month, String year) {
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();
    }

}
