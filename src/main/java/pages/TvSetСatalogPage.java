package pages;

import driver.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Helpers;
import java.util.Set;

public class TvSetСatalogPage extends BasePage {
    @FindBy(id = "glpricefrom")
    private WebElement priceFrom;

    @FindBy(className = "_38V6fgYMij")
    private WebElement formTV;

    @FindBy(xpath = "(//*[@data-zone-name=\"snippetList\"]//following::article)[1]//ancestor-or-self::img")
    private WebElement firstTV;

    private By form = By.xpath("//*[@data-tid=\"67d9be0a\"]");
    private String manufacturer = "//*[@class=\"NVoaOvqe58\" and text()='%s']";

    public TvSetСatalogPage() {
        PageFactory.initElements(Driver.getInstance(),this);
    }


    @Step("Ввести сумму в поле Цена, ₽ от")
    public TvSetСatalogPage selectMinPrise(String priceMin){
        priceFrom.sendKeys(priceMin);
        Helpers.saveScreenshot(((TakesScreenshot) Driver.getInstance()).getScreenshotAs(OutputType.BYTES));
        return this;
    }

    @Step("Выбрать бренд телевизора")
    public TvSetСatalogPage selectBrandTvSet(String brandTvSet){
        Helpers.checkElementPresenceAndFindIt(By.xpath(String.format(manufacturer,brandTvSet))).click();
        Helpers.saveScreenshot(((TakesScreenshot) Driver.getInstance()).getScreenshotAs(OutputType.BYTES));
        return this;
    }

    @Step("Переключиться на открытую вкладку товара")
    public TvSetPage chooseFirstTvSet(){
        Set<String> oldWindowsSet = Helpers.getWindowHandles();
        WebElement formDisable = Helpers.checkElementPresenceAndFindIt(form);
        Helpers.checkElementStalenessOf(formDisable);
        firstTV.click();
        Set<String> newWindowsSet = Helpers.getWindowHandles();
        Driver.getInstance().switchTo().window(Helpers.getNewWindowHandle(oldWindowsSet, newWindowsSet));
        Helpers.saveScreenshot(((TakesScreenshot) Driver.getInstance()).getScreenshotAs(OutputType.BYTES));
        return new TvSetPage();

    }

}
