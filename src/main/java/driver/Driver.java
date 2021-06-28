package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

    private static WebDriver instance;

    private Driver() {

    }

    public static synchronized WebDriver getInstance() {
        if (instance == null) {

            WebDriverManager.chromedriver().setup();
            instance = new ChromeDriver();
            instance.manage().window().maximize();
        }
        return instance;
    }

    public static void stopDriver() {
        instance.quit();
        instance = null;
    }
}