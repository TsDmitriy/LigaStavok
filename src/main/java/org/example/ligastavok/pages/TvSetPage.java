package org.example.ligastavok.pages;

import org.example.ligastavok.driver.Driver;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.example.ligastavok.utils.Helpers;

import java.util.ArrayList;
import java.util.Arrays;

public class TvSetPage extends BasePage {

    public TvSetPage(){
        PageFactory.initElements(Driver.getInstance(), this);
    }

    @FindBy(xpath = "//*[@class=\"_10o2cPu4Fn\"]")
    private WebElement priсeTV;

    @FindBy(className = "x__tNeZtug")
    private WebElement brandTV;

    @Step("Цена телевизора соотвествует параметрам установленным в фильтре")
    public TvSetPage checkPriсeTvMoreOrEqual(int priceEstablished) {
        int price = Integer.parseInt(priсeTV.getText().replaceAll("[^0-9]", ""));
        Assertions.assertTrue(price >= priceEstablished);
        Helpers.saveScreenshot(((TakesScreenshot) Driver.getInstance()).getScreenshotAs(OutputType.BYTES));
        return this;
    }

    @Step("Бренд телевизора соотвествует параметрам установленным в фильтре")
    public void checkBrandTvEqual(String... brands) {
        ArrayList<String> listBrand = new ArrayList<>(Arrays.asList(brands));
        String descriptionTV = brandTV.getText();
        Assertions.assertTrue(listBrand.stream().anyMatch(descriptionTV::contains),"Бренд телевизора не соотвествует брендам заданным в фильтре:" + String.join(",", brands));
        Helpers.saveScreenshot(((TakesScreenshot) Driver.getInstance()).getScreenshotAs(OutputType.BYTES));
    }

}
