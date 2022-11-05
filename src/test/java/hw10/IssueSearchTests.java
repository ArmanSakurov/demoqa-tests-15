package hw10;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import hw10.pages.GithubMainPage;
import hw10.pages.GithubSearchPage;
import hw10.pages.RepositoryPage;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import selenide.WebSteps;
import static io.qameta.allure.Allure.step;

public class IssueSearchTests {

    GithubMainPage githubMainPage = new GithubMainPage();
    GithubSearchPage githubSearchPage = new GithubSearchPage();
    RepositoryPage repositoryPage = new RepositoryPage();

    private static final String REPOSITORY = "ArmanSakurov/demoqa-tests-15";
    private static final String githubUrl = "https://github.com";
    private static final String ISSUE = "Test issue for HW";

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    @DisplayName("Check issue title")
    public void checkIssueName() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        githubMainPage.openPage(githubUrl)
                .searchInputClick()
                .fillSearchInput(REPOSITORY)
                .searchSubmit();
        githubSearchPage.clickRepositoryLink(REPOSITORY);
        repositoryPage.clickIssuesTab().checkIssueTitle(ISSUE);
    }

    @Test
    @DisplayName("Check issue title - lambda steps")
    public void testLambdaStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            githubMainPage.openPage(githubUrl);
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            githubMainPage.searchInputClick().fillSearchInput(REPOSITORY).searchSubmit();
        });
        step("Кликаем по ссылке репозитория " + REPOSITORY, () -> {
            githubSearchPage.clickRepositoryLink(REPOSITORY);
        });
        step("Открываем таб Issues", () -> {
            repositoryPage.clickIssuesTab();
        });
        step("Проверяем наличие Issue по названию: " + ISSUE, () -> {
            repositoryPage.clickIssuesTab().checkIssueTitle(ISSUE);
        });
    }

    @Test
    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @Owner("ArmanSakurov")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Check issue title - step annotation")
    public void testAnnotatedStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueByName(ISSUE);
    }
}
