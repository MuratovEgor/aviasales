package ru.aviasales.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.aviasales.helpers.CommonSteps;
import ru.aviasales.helpers.DriverUtils;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class ConsoleLogTest extends TestBase {

    CommonSteps commonSteps = new CommonSteps();


    @Test
    @DisplayName("В консоли нет ошибок")
    void consoleShouldNotHaveErrorsTest() {
        commonSteps.openPage("/");

        step("В консоли нет ошибок типа 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}