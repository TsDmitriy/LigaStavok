package Pages;

import Driver.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Helpers;

import java.io.IOException;
import java.util.Set;

public class TvSetPage extends MainPage {
    @FindBy(id = "glpricefrom")
    private WebElement priceFrom;

    @FindBy(className = "_38V6fgYMij")
    private WebElement formTV;

    @FindBy(xpath = "(//*[@data-zone-name=\"snippetList\"]//following::article)[1]//ancestor-or-self::img")
    private WebElement firstTV;

    public By form = By.xpath("//*[@data-tid=\"67d9be0a\"]");

    public TvSetPage() throws IOException {
    }

    @Step("Пользователь вводит сумму в поле Цена, ₽ от")
    public TvSetPage selectMinPrise(String priseMin){
        priceFrom.sendKeys(priseMin);
        Helpers.saveScreenshot(((TakesScreenshot) Driver.getInstance()).getScreenshotAs(OutputType.BYTES));
        return this;
    }

    @Step("Пользователь выбирает бренд телевизора")
    public TvSetPage selectBrendTVset(String brendTVset) throws IOException {
        Helpers.presenceOfElementLocatedAmdFindElement(By.xpath("//*[@class=\"NVoaOvqe58\" and text()='" + brendTVset + "']")).click();
        Helpers.saveScreenshot(((TakesScreenshot) Driver.getInstance()).getScreenshotAs(OutputType.BYTES));
        return this;
    }

    @Step("Пользователь выбирает первый найденный телевизор")
    public FirstTvSet choiseFirstTvSet() throws IOException {
        Set<String> oldWindowsSet = Helpers.getWindowHandles();
        WebElement formDisaible = Helpers.presenceOfElementLocatedAmdFindElement(form);
        Helpers.stalenessOf(formDisaible);
        firstTV.click();
        Set<String> newWindowsSet = Helpers.getWindowHandles();
        Driver.getInstance().switchTo().window(Helpers.getNewWindowHandles(oldWindowsSet, newWindowsSet));
        Helpers.saveScreenshot(((TakesScreenshot) Driver.getInstance()).getScreenshotAs(OutputType.BYTES));
        return new FirstTvSet();

    }

}
