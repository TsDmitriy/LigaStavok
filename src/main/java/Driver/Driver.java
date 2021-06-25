package Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

    private static WebDriver instance;

    private Driver() {

    }

    /**
     * Метод проверяет есть ли instance WebDriver, если нет, то создает новый
     *
     * @return instance
     */
    public static synchronized WebDriver getInstance() {
        if (instance == null) {

            WebDriverManager.chromedriver().setup();
            instance = new ChromeDriver();
            instance.manage().window().maximize();
        }
        return instance;
    }

    /**
     * Метод который завершает работу браузера и сервисов
     */
    public static void stopDriver() {
        instance.quit();
        instance = null;
    }
}