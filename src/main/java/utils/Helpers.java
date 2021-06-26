package utils;

import driver.Driver;
import io.qameta.allure.Attachment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class Helpers {
    /**
     * Метод проверет виден ли элемент в дом, если виден возвращает элемент
     *
     * @param by путь до элемента в DOM
     * @return найденный WebElement
     */
    public static WebElement checkElementPresenceAndFindIt(By by)  {
        new WebDriverWait(Driver.getInstance(), 15)
                .withMessage("Элемент" + by + "не виден в DOM")
                .until(ExpectedConditions.presenceOfElementLocated(by));
        return Driver.getInstance().findElement(by);
    }

    /**
     * Метод ожидает, что элемента больше нет.
     *
     * @param webElement веб элемент
     */
    public static void checkElementStalenessOf(WebElement webElement) {
        new WebDriverWait(Driver.getInstance(), 15)
                .withMessage("Элемент" + webElement + " присутствует в DOM")
                .until(ExpectedConditions.stalenessOf(webElement));
    }

    /**
     * Метод получает дескриптор страницы
     *
     * @return Set<String>
     */
    public static Set<String> getWindowHandles() {
        return Driver.getInstance().getWindowHandles();
    }

    /**
     * Метод возвращает дискриптор новой открытой страницы
     *
     * @param oldWindowsSet множество сожержащие дискриптор текущей страницы
     * @param newWindowsSet множество сожержащее дискрипторы октрытых страниц
     * @return дискриптор новой открытой страницы
     */
    public static String getNewWindowHandles(Set<String> oldWindowsSet, Set<String> newWindowsSet) {
        String newWindowHandle = (new WebDriverWait(Driver.getInstance(), 10))
                .until(new ExpectedCondition<String>() {
                    public String apply(WebDriver driver) {
                        newWindowsSet.removeAll(oldWindowsSet);
                        return newWindowsSet.size() > 0 ?
                                newWindowsSet.iterator().next() : null;
                    }
                });
        return newWindowHandle;
    }

    @Attachment(value = "Снимок экрана", type = "image/png")
    public static byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }

}
