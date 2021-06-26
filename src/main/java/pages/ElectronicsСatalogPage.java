package pages;

import driver.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Helpers;

public class ElectronicsСatalogPage extends BasePage {

    public ElectronicsСatalogPage() {
        PageFactory.initElements(Driver.getInstance(), this);
    }

    @FindBy(xpath = "//*[@class=\"_1Y6X2G3jjK\"]//*[text()='Телевизоры']")
    private WebElement tvSet;

    /**
     * Метод осуществляет переход на страницу раздела Телевизоры
     *
     * @return
     */
    @Step("Выбрать подкатегорию \"Телевизоры\"")
    public TvSetСatalogPage goToTvSetPage() {
        tvSet.click();
        Helpers.saveScreenshot(((TakesScreenshot) Driver.getInstance()).getScreenshotAs(OutputType.BYTES));
        return new TvSetСatalogPage();
    }

}
