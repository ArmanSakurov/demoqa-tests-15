package hw10.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GithubMainPage {

    public SelenideElement
            searchInput = $(".header-search-input");


    public GithubMainPage openPage(String url) {
        open(url);
        searchInput.shouldBe(visible);

        return this;
    }

    public GithubMainPage searchInputClick() {
        searchInput.click();

        return this;
    }

    public GithubMainPage fillSearchInput(String value) {
        searchInput.sendKeys(value);

        return this;
    }

    public void searchSubmit() {
        searchInput.submit();

    }
}
