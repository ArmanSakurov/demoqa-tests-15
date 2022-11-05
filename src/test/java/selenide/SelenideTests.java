package selenide;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTests {

    public static String dragAndDropUrl = "https://the-internet.herokuapp.com/drag_and_drop";

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    @DisplayName("Check enterprise page content")
    void hoverTest() {
        open("https://github.com/");
        $(".header-menu-wrapper").$(byText("Solutions")).hover();
        $(byText("Enterprise")).click();
        $("h1").shouldHave(text("Build like the best"));
    }

    @Test
    @DisplayName("Check drag and drop")
    void dragAndDropTest() {
        open(dragAndDropUrl);
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
        $("#column-a").dragAndDropTo("#column-b");
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }

    @Test // Метод не работает
    @DisplayName("Check drag and drop via selenide actions")
    void selenideActionsDragAndDropTest() {
        open(dragAndDropUrl);
        actions().moveToElement($("#column-a")).clickAndHold().moveToElement($("#column-a"))
                .release().perform();
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
