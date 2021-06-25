import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class MainPage {

    @FindBy(xpath = "//*[@href=\"/catalog--elektronika/54440\"]")
    private WebElement elektronika;

    public MainPage() throws IOException {
        PageFactory.initElements(Driver.getInstance(),this);
    }

    /**
     * Метод осуществляет переход на страницу раздела Электроника
     * @return ElektronikaPage
     */
    @Step("Переход на страницу Электроника")
    public ElektronikaPage goToElektronikaPage() throws IOException {
        elektronika.click();
        Helpers.saveScreenshot(((TakesScreenshot) Driver.getInstance()).getScreenshotAs(OutputType.BYTES));
        return new ElektronikaPage();
    }
}
