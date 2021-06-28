package org.example.ligastavok.pages;

import org.example.ligastavok.driver.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.example.ligastavok.utils.Helpers;

public class BasePage {
    private String url = "https://market.yandex.ru/";
    public BasePage() {
        PageFactory.initElements(Driver.getInstance(),this);
    }

    @Step("Открыть главную страницу")
    public MainPage goToMainPage(){
        Driver.getInstance().get(url);
        Helpers.saveScreenshot(((TakesScreenshot) Driver.getInstance()).getScreenshotAs(OutputType.BYTES));
        return new MainPage();
    }

}
