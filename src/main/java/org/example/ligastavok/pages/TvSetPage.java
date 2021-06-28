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
    private WebElement priseTV;

    @FindBy(className = "x__tNeZtug")
    private WebElement brendTV;

    @Step("Цена телевизора соотвествует параметрам установленным в фильтре")
    public TvSetPage checkPriseTvMoreOrEqual(int priseEstablished) {
        Integer prise = Integer.parseInt(priseTV.getText().replaceAll("[^0-9]", ""));
        Assertions.assertTrue(prise >= priseEstablished);
        Helpers.saveScreenshot(((TakesScreenshot) Driver.getInstance()).getScreenshotAs(OutputType.BYTES));
        return this;
    }

    @Step("Бренд телевизора соотвествует параметрам установленным в фильтре")
    public void checkBrendTvEqual(String... brends) {
        ArrayList<String> listBrend = new ArrayList<>(Arrays.asList(brends));
        String descriptionTV = brendTV.getText();
        for (String s : listBrend) {
            if (descriptionTV.contains(s)) {
                break;
            } else {
                Assertions.fail("Бренд телевизора не соотвествует брендам заданным в фильтре:" + String.join(",", brends));
            }
        }
        Helpers.saveScreenshot(((TakesScreenshot) Driver.getInstance()).getScreenshotAs(OutputType.BYTES));
    }
}
