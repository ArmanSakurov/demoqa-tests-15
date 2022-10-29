package github;

import github.pages.GithubPage;
import org.junit.jupiter.api.Test;

public class SelenideWikiTest {
    GithubPage githubPage = new GithubPage();
    public static String wikiPage = "SoftAssertions";

    @Test
    void checkJUnitExampleCodeTest() {

        githubPage.openPage("https://github.com/selenide/selenide", "Selenide = UI Testing Framework")
                .openWiki()
                .setWikiPage(wikiPage)
                .clickButtonByText(wikiPage)
                .checkPageContent("Using JUnit5 extend test class");
    }
}
