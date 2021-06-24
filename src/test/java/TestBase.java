import org.junit.AfterClass;
import org.junit.BeforeClass;

import java.io.IOException;

public class TestBase {
    @BeforeClass
    public static void startDriver() throws IOException {
        new GoToMainPage().goToMainPage();

    }
    @AfterClass
    public static void stopDriver() {
        Driver.stopDriver();

    }
}
