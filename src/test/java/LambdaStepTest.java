import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.*;

public class LambdaStepTest {

    private static final String REPOSITORY = "Sago0/qa_guru_4_5";
    private static final String ISSUE_NAME = "Issue example";
    private static final String BASE_URL = "https://github.com/";


    @Test
    @Owner("Me")
    @Tags({@Tag("wed"), @Tag("major")})
//    @Link(name = "Base URL", value = BASE_URL)
    @Feature("Issue")
    @Story("Поиск Issue")
    @DisplayName("Поиск Issue по имени")
    public void testIssueSearch() {
        parameter("Repository", REPOSITORY);
        parameter("Issue Name", ISSUE_NAME);
        link("GitHub", String.format("%s/%s", BASE_URL, REPOSITORY));

        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Отрываем GitHub", () -> open(BASE_URL));
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Переходим в репозиторий " + REPOSITORY, () -> $(By.linkText(REPOSITORY)).click());
        step("Переходим в раздел Issues", () -> $("#issues-tab").click());
        step("Проверяем наличие " + ISSUE_NAME, () -> {
            $(withText(ISSUE_NAME)).should(Condition.exist);
        });
    }
}
