package ru.aviasales.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.aviasales.helpers.CommonSteps;
import ru.aviasales.pages.HomePage;

public class HomePageTests extends TestBase {

    String title = "Поиск дешёвых авиабилетов",
            linkShowMultiWayForm = "Составить сложный маршрут",
            linkShowBasicForm = "Вернуться к простому маршруту";
    CommonSteps commonSteps = new CommonSteps();
    HomePage homePage = new HomePage();


    @BeforeEach
    void openPage() {
        commonSteps.openPage("/");
    }


    @Test
    @DisplayName("Заголовок страницы")
    void checkPageTitle() {
        homePage.checkPageTitle(title);
    }

    @Test
    @DisplayName("Чек бокс 'Открыть Booking' по умолчанию выбран")
    void checkBookingCheckBoxSelected() {
        homePage.bookingCheckboxChecked();
    }

    @Test
    @DisplayName("При клике на чек бокс 'Открыть Booking' выбран с него снимается")
    void checkBookingCheckBoxNotSelected() {
        homePage.clickByBookingCheckbox();
        homePage.bookingCheckboxNotChecked();
    }

    @Test
    @DisplayName("Изменения внешнего вида формы поиска с обычного на мультипоиск и обратно")
    void changeViewSearchForm() {
        homePage.chekTextByLinkMultiwayChangeForm(linkShowMultiWayForm);
        homePage.clickByLinkShowMultiwayChangeForm();

        homePage.chekTextByLinkBasicChangeForm(linkShowBasicForm);
        homePage.clickByLinkShowBasicChangeForm();
    }
}
