
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;

public class TestBase {
    @BeforeAll
    public static void startDriver() throws IOException {
        new GoToMainPage().goToMainPage();

    }
    @AfterAll
    public static void stopDriver() {
        Driver.stopDriver();

    }
}
