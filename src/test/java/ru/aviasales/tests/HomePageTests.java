package ru.aviasales.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.aviasales.pages.HomePage;

public class HomePageTests extends TestBase {

    String title = "Поиск дешёвых авиабилетов",
            linkShowMultiWayForm = "Составить сложный маршрут",
            linkShowBasicForm = "Вернуться к простому маршруту",
            from = "Москва",
            to = "Лондон";
    HomePage homePage = new HomePage();


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

    @Test
    @DisplayName("При попытке найти билеты без указания даты отображается ошибка")
    void searchTicketWithoutDateOfDeparture() {
        homePage.typeFrom(from);
        homePage.typeTo(to);
        homePage.clickBtnSubmit();

        homePage.checkErrorMessageOverInputDeparture();
    }

    @Test
    @DisplayName("Если не указан место отправления то отображается ошибка")
    void searchTicketWithoutFrom() {
        homePage.typeFrom("");
        homePage.clickBtnSubmit();

        homePage.checkErrorMessageOverInputFrom();

    }
}
