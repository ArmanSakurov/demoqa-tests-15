package hw10.pages;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.linkText;

public class GithubSearchPage {

    public void clickRepositoryLink(String value) {
        $(linkText(value)).click();

    }
}
