package Pages;

import Driver.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.Helpers;

import java.io.IOException;

public class MarketYandex {
    private String url = "https://market.yandex.ru/";

    /**
     * Метод осуществляет переход на главную страницу приложения
     *
     * @return новую страницу Pages.MainPage
     */
    @Step("Переход на страницу \"market.yandex.ru\"")
    public MainPage goToMainPage() throws IOException {
        Driver.getInstance().get(url);
        Helpers.saveScreenshot(((TakesScreenshot) Driver.getInstance()).getScreenshotAs(OutputType.BYTES));
        return new MainPage();
    }

}
