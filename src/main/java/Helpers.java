import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class Helpers {
    /**
     * Метод проверет виден ли элемент в дом, если виден возвращает элемент
     *
     * @param by путь до элемента в DOM
     * @return найденный WebElement
     */
    public static WebElement presenceOfElementLocatedAmdFindElement(By by) throws IOException {
        new WebDriverWait(Driver.getInstance(), 15)
                .withMessage("Элемент" + by + "не виден в DOM")
                .until(ExpectedConditions.presenceOfElementLocated(by));
        return Driver.getInstance().findElement(by);
    }

    /**
     * Метод проверяет, что элемент присутствует в DOM страницы, является видимым.
     *
     * @param webElement
     */
    public static WebElement invisibilityOf(WebElement webElement) {
        new WebDriverWait(Driver.getInstance(), 15)
                .withMessage("Элемент" + webElement + "не присутствует в DOM страницы, или является невидимым.")
                .until(ExpectedConditions.invisibilityOf(webElement));
        return webElement;
    }

    /**
     * Метод проверет виден ли элемент в дом, если виден возвращает элемент
     *
     * @return найденный WebElement
     */
    public static void waitLoadPage() {
        new WebDriverWait(Driver.getInstance(), 30)
                .until(ExpectedConditions
                        .jsReturnsValue("return document.readyState==\"complete\";"));

    }

    /**
     * Метод ожидает, что элемента больше нет.
     *
     * @param webElement веб элемент
     */
    public static void stalenessOf(WebElement webElement) {
        new WebDriverWait(Driver.getInstance(), 15)
                .withMessage("Элемент" + webElement + "не присутствует в DOM страницы, или является невидимым.")
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

    public static void getScreenshotAs() throws IOException {
        String pathScreenshot = "C:\\Screen\\" +(int) System.currentTimeMillis() +".png";
        TakesScreenshot scrShot = ((TakesScreenshot) Driver.getInstance());
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(pathScreenshot);
        try {
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
