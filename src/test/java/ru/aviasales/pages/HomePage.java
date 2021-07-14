package ru.aviasales.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    SelenideElement pageTitle = $(".header__title"),
            wrapperOpenBookingCheckbox = $(".avia-form__booking"),
            openBookingCheckbox = $("#clicktripz"),
            linkShowMultiwayChangeForm = $(".avia-form__change-form"),
            linkShowBasicChangeForm = $(".multiway-form__change-form");


    @Step("В заголовке отображается текст: {title}")
    public void checkPageTitle(String title) {
        pageTitle.shouldHave(text(title));
    }

    @Step("Отобразить расширенную форму")
    public void clickByLinkShowMultiwayChangeForm() {
        linkShowMultiwayChangeForm.click();

        linkShowBasicChangeForm.shouldBe(visible);
        linkShowMultiwayChangeForm.shouldNotBe(visible);
    }

    @Step("Отобразить базовую форму")
    public void clickByLinkShowBasicChangeForm() {
        linkShowBasicChangeForm.click();

        linkShowMultiwayChangeForm.shouldBe(visible);
        linkShowBasicChangeForm.shouldNotBe(visible);
    }

    @Step("У ссылки для отображения расширенной формы отображается текст: {text}")
    public void chekTextByLinkMultiwayChangeForm(String text) {
        linkShowMultiwayChangeForm.shouldHave(text(text));
    }

    @Step("У ссылки для отображения базовой формы отображается текст: {text}")
    public void chekTextByLinkBasicChangeForm(String text) {
        linkShowBasicChangeForm.shouldHave(text(text));
    }

    @Step("Клик по checkBox 'Открыть Booking'")
    public void clickByBookingCheckbox() {
        wrapperOpenBookingCheckbox.click();
    }

    @Step("CheckBox 'Открыть Booking' выбран")
    public void bookingCheckboxChecked() {
        openBookingCheckbox.shouldBe(checked);
    }

    @Step("CheckBox 'Открыть Booking' невыбран")
    public void bookingCheckboxNotChecked() {
        openBookingCheckbox.shouldNotBe(checked);
    }

}
