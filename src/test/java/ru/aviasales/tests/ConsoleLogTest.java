package ru.aviasales.tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.aviasales.helpers.DriverUtils;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class ConsoleLogTest extends TestBase {


    @Test
    @DisplayName("В консоли нет ошибок")
    void consoleShouldNotHaveErrorsTest() {
        step("Открыть главную страницу 'https://www.aviasales.ru/'", () ->
                open("/"));

        step("В консоли нет ошибок типа 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}