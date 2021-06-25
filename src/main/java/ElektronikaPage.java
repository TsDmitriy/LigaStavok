import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ElektronikaPage extends MainPage {

    public ElektronikaPage() throws IOException {
        PageFactory.initElements(Driver.getInstance(),this);
    }
    @FindBy(xpath = "//*[@class=\"_1Y6X2G3jjK\"]//*[text()='Телевизоры']")
    private WebElement tVSet;

    /**
     * Метод осуществляет переход на страницу раздела Телевизоры
     * @return
     */
    public TvSetPage goToTvSetPage() throws IOException {
        tVSet.click();
        Helpers.saveScreenshot(((TakesScreenshot) Driver.getInstance()).getScreenshotAs(OutputType.BYTES));
        return new TvSetPage();
    }

}
