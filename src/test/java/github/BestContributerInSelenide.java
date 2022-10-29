package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class BestContributerInSelenide {

    @Test
    void andreiSolntsevShouldBeTheFirstContributer(){
        open("https://github.com/selenide/selenide");
        $(".Layout-sidebar").$(byText("Contributors"))
                .ancestor(".BorderGrid-cell").$$("ul li")
                .first().hover();
        $$(".Popover-message").findBy(visible).shouldHave(text("Andrei Solntsev"));
    }
}
