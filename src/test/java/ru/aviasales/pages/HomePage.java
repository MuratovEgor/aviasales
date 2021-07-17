package ru.aviasales.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    SelenideElement pageTitle = $(".header__title"),
            wrapperOpenBookingCheckbox = $(".avia-form__booking"),
            openBookingCheckbox = $("#clicktripz"),
            linkShowMultiwayChangeForm = $(".avia-form__change-form"),
            linkShowBasicChangeForm = $(".multiway-form__change-form"),
            inputFrom = $("#origin"),

            inputTo = $("#destination"),
            inputDeparture = $(".trip-duration__input-wrapper.--departure .trip-duration__date-input"),
            inputReturn = $(".trip-duration__input-wrapper.--return .trip-duration__date-input"),
            selectPassengers = $("div.avia-form__field.--passengers]"),
            buttonSearch = $("button[type=submit]"),
            errorDeparture = $(".trip-duration__field.--departure.--error"),
            errorFrom = $(By.xpath("//input[@id='origin']/parent::div[@class='autocomplete__input-wrapper --error']"));

    ;

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

    @Step("Ввести в поле Откуда текст: {from}")
    public void typeFrom(String from) {
        inputFrom.val(from);
    }

    @Step("Ввести в поле Куда текст: {to}")
    public void typeTo(String to) {
        inputTo.val(to);
    }

    @Step("Нажать на кнопку 'Найти билеты'")
    public void clickBtnSubmit() {
        buttonSearch.click();
    }

    @Step("Отображается ошибка над полем Дата вылета")
    public void checkErrorMessageOverInputDeparture() {
        errorDeparture.shouldBe();
    }

    @Step("Отображается ошибка над полем Откуда")
    public void checkErrorMessageOverInputFrom() {
        errorFrom.shouldBe();
    }


}
