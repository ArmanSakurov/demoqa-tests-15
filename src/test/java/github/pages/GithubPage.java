package github.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GithubPage {

    public SelenideElement readmeContentContainer = $("#readme"),
            wikiButton = $("#wiki-tab"),
            wikiPageInput = $("#wiki-pages-filter"),
            wikiPage = $("#wiki-pages-box"),
            wikiContent = $("#wiki-content");

    public GithubPage openPage(String url, String contentText) {
        open(url);
        readmeContentContainer.shouldHave(text(contentText));

        return this;
    }

    public GithubPage openWiki() {
        wikiButton.click();

        return this;
    }

    public GithubPage setWikiPage(String value) {
        wikiPageInput.setValue(value).pressEnter();

        return this;
    }

    public GithubPage clickButtonByText(String buttonText) {
        wikiPage.$(byText(buttonText)).click();

        return this;
    }

    public GithubPage checkPageContent(String contentText) {
        wikiContent.shouldHave(text(contentText));

        return this;
    }




}
