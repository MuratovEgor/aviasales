package ru.aviasales.tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.BeforeEach;
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
    @Description("Проверка заголовка страницы")
    void checkPageTitle() {
        homePage.checkPageTitle(title);
    }

    @Test
    void checkBookingCheckBoxSelected() {
        homePage.bookingCheckboxChecked();
    }

    @Test
    void checkBookingCheckBoxNotSelected() {
        homePage.clickByBookingCheckbox();
        homePage.bookingCheckboxNotChecked();
    }

    @Test
    void changeViewSearchForm() {
        homePage.chekTextByLinkMultiwayChangeForm(linkShowMultiWayForm);
        homePage.clickByLinkShowMultiwayChangeForm();

        homePage.chekTextByLinkBasicChangeForm(linkShowBasicForm);
        homePage.clickByLinkShowBasicChangeForm();
    }
}
