package ru.aviasales.pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class SearchForm {
    SelenideElement ORIGIN_FIELD = $("[data-testid='origin-autocomplete-field']"),
            DESTINATION_FIELD = $("[data-testid='destination-autocomplete-field']"),
            BTN_FORM_SUBMIT = $("[data-testid='form-submit']"),
            DEPARTURE_DATA_FIELD = $(".trip-duration__field.--departure");


    @Step("Enter in the field Origin: {origin}")
    public void typeOrigin(String origin) {
        ORIGIN_FIELD.clear();
        ORIGIN_FIELD.val(origin);
    }

    @Step("Enter in the field Destination: {destination}")
    public void typeDestination(String destination) {
        DESTINATION_FIELD.clear();
        DESTINATION_FIELD.val(destination);
    }

    @Step("Submit search form")
    public void submitForm() {
        BTN_FORM_SUBMIT.click();
    }

    @Step("Check that the warning 'Departure Data Field Is Empty' is displayed")
    public void checkWarningDepartureDataIsEmpty(){
        DEPARTURE_DATA_FIELD.shouldHave(Condition.cssClass("--error"))
                .shouldHave(Condition.attribute("data-error-message"));
    }
}
