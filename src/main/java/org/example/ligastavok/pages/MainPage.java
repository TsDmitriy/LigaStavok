package org.example.ligastavok.pages;
import org.example.ligastavok.driver.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.example.ligastavok.utils.Helpers;

public class  MainPage extends BasePage{

    @FindBy(xpath = "//*[@href=\"/catalog--elektronika/54440\"]")
    private WebElement electronics;

    public MainPage() {
        PageFactory.initElements(Driver.getInstance(),this);
    }

    @Step("Выбрать категорию \"Электроника\"")
    public ElectronicsСatalogPage goToElectronicsPage(){
        electronics.click();
        Helpers.saveScreenshot(((TakesScreenshot) Driver.getInstance()).getScreenshotAs(OutputType.BYTES));
        return new ElectronicsСatalogPage();
    }
}
