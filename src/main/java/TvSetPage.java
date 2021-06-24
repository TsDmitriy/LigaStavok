import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public TvSetPage selectMinPrise(String priseMin) throws IOException {
        priceFrom.sendKeys(priseMin);
        Helpers.getScreenshotAs();
        return this;
    }

    public TvSetPage selectBrendTVset(String brendTVset) throws IOException {
        Helpers.presenceOfElementLocatedAmdFindElement(By.xpath("//*[@class=\"NVoaOvqe58\" and text()='"+ brendTVset +"']")).click();
        Helpers.getScreenshotAs();
        return this;
    }
    public FirstTvSet choiseFirstTvSet() throws IOException {
        Set<String> oldWindowsSet = Helpers.getWindowHandles();
        WebElement formDisaible = Helpers.presenceOfElementLocatedAmdFindElement(form);
        Helpers.stalenessOf(formDisaible);
        firstTV.click();
        Set<String> newWindowsSet = Helpers.getWindowHandles();
        Driver.getInstance().switchTo().window(Helpers.getNewWindowHandles(oldWindowsSet,newWindowsSet));
        Helpers.getScreenshotAs();
        return new FirstTvSet();

    }

}
