package org.example.ligastavok.pages;

import org.example.ligastavok.driver.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.example.ligastavok.utils.Helpers;

public class ElectronicsCatalogPage extends BasePage {

    @FindBy(xpath = "//*[@class=\"_1Y6X2G3jjK\"]//*[text()='Телевизоры']")
    private WebElement tvSet;

    @Step("Выбрать подкатегорию \"Телевизоры\"")
    public TvPage goToTvSetPage() {
        tvSet.click();
        Helpers.saveScreenshot(((TakesScreenshot) Driver.getInstance()).getScreenshotAs(OutputType.BYTES));
        return new TvPage();
    }

}
