package ru.aviasales.helpers;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;

public class CommonSteps {
    @Step("Открыть страницу {url}")
    public void openPage(String url) {
        open(url);
    }
}
