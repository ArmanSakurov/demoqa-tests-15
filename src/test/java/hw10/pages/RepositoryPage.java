package hw10.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.linkText;

public class RepositoryPage {

    public RepositoryPage clickIssuesTab() {
        $("#issues-tab").click();

        return this;
    }

    public RepositoryPage checkIssueTitle(String value) {
        $(linkText(value)).shouldBe(visible);

        return this;
    }
}
