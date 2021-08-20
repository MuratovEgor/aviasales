package ru.aviasales.tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;
import ru.aviasales.annotations.JiraIssue;
import ru.aviasales.annotations.JiraIssues;
import ru.aviasales.annotations.Layer;
import ru.aviasales.config.Project;
import ru.aviasales.pageObjects.SearchForm;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Story;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Layer("Web")
@Owner("egormuratov")
public class SearchFormTests {
    SearchForm searchForm = new SearchForm();

    @BeforeAll
    static void configureBaseUrl() {
        Configuration.baseUrl = Project.config.baseUrl();
        step("open Home page", () -> {
            open("");
        });
    }


    @Test
    @Story("Negative test for Search form")
    @JiraIssues({@JiraIssue("AE-1")})
    @Tags({@Tag("web"), @Tag("regress")})
    @DisplayName("A warning should be displayed if the Departure field is empty")
    void checkWarningDepartureDataIsEmptyTest() {
        searchForm.typeOrigin("Moscow");
        searchForm.typeDestination("New York");
        searchForm.submitForm();

        searchForm.checkWarningDepartureDataIsEmpty();
    }
}
