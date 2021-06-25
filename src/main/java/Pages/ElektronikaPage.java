package Pages;

import Driver.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Helpers;

import java.io.IOException;

public class ElektronikaPage extends MainPage {

    public ElektronikaPage() {
        PageFactory.initElements(Driver.getInstance(), this);
    }

    @FindBy(xpath = "//*[@class=\"_1Y6X2G3jjK\"]//*[text()='Телевизоры']")
    private WebElement tVSet;

    /**
     * Метод осуществляет переход на страницу раздела Телевизоры
     *
     * @return
     */
    @Step("Переход на страницу \"Телевизоры\"")
    public TvSetPage goToTvSetPage() throws IOException {
        tVSet.click();
        Helpers.saveScreenshot(((TakesScreenshot) Driver.getInstance()).getScreenshotAs(OutputType.BYTES));
        return new TvSetPage();
    }

}
