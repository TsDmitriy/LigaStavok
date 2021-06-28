package org.example.ligastavok.utils;

import org.example.ligastavok.driver.Driver;
import io.qameta.allure.Attachment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class Helpers {
    public static WebElement checkElementPresenceAndFindIt(By by)  {
        new WebDriverWait(Driver.getInstance(), 15)
                .withMessage("Элемент" + by + "не виден в DOM")
                .until(ExpectedConditions.presenceOfElementLocated(by));
        return Driver.getInstance().findElement(by);
    }

    public static void checkElementStalenessOf(WebElement webElement) {
        new WebDriverWait(Driver.getInstance(), 15)
                .withMessage("Элемент" + webElement + " присутствует в DOM")
                .until(ExpectedConditions.stalenessOf(webElement));
    }

    public static Set<String> getWindowHandles() {
        return Driver.getInstance().getWindowHandles();
    }

    public static String getNewWindowHandle(Set<String> oldWindowsSet, Set<String> newWindowsSet) {
        String newWindowHandle="";
        try {
              newWindowHandle = (new WebDriverWait(Driver.getInstance(), 10))
                    .until(new ExpectedCondition<String>() {
                        public String apply(WebDriver driver) {
                            newWindowsSet.removeAll(oldWindowsSet);
                            return newWindowsSet.size() > 0 ?
                                    newWindowsSet.iterator().next() : null;
                        }
                    });

        }
        catch (Exception e) {
            System.out.println("Новое  окно или вкладка не открылась");
        }
        return newWindowHandle;
    }

    @Attachment(value = "Снимок экрана", type = "image/png")
    public static byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }

}
