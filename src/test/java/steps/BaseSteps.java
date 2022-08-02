package steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BaseSteps {

    private static final String BASE_URL = "https://github.com/";


    @Step("Отрываем GitHub")
    public void openMainPage() {
        open(BASE_URL);
    }

    @Step("Ищем репозиторий {repository}")
    public void searchRepository(final String repository) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();
    }

    @Step("Переходим в репозиторий {repository}")
    public void openRepository(final String repository) {
        $(By.linkText(repository)).click();
    }

    @Step("Переходим в раздел Issues")
    public void openIssuesTab() {
        $("#issues-tab").click();
    }

    @Step("Проверяем наличие {issueName}")
    public void checkIssueName(final String issueName) {
        $(withText(issueName)).should(Condition.exist);
    }

}
