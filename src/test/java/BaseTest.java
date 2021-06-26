
import driver.Driver;
import pages.BasePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    @BeforeAll
    public static void startDriver() {
        new BasePage().goToMainPage();

    }
    @AfterAll
    public static void stopDriver() {
        Driver.stopDriver();

    }
}
