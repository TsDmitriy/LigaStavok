package pages;

import driver.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import utils.Helpers;

public class BasePage {
    private String url = "https://market.yandex.ru/";
    public BasePage() {
        PageFactory.initElements(Driver.getInstance(),this);
    }
    /**
     * Метод осуществляет переход на главную страницу приложения
     *
     * @return новую страницу Pages.MainPage
     */
    @Step("Открыть главную страницу")
    public MainPage goToMainPage(){
        Driver.getInstance().get(url);
        Helpers.saveScreenshot(((TakesScreenshot) Driver.getInstance()).getScreenshotAs(OutputType.BYTES));
        return new MainPage();
    }

}
