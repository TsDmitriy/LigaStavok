import org.junit.jupiter.api.Test;
import pages.MainPage;

public class CheckFilterPriceAndBrandTest extends BaseTest {

    @Test
    public void test() {
        new MainPage()
                .goToElectronicsPage()
                .goToTvSetPage()
                .selectMinPrise("20000")
                .selectBrandTvSet("LG")
                .selectBrandTvSet("Samsung")
                .chooseFirstTvSet()
                .checkPriseTvMoreOrEqual(20000)
                .checkBrendTvEqual("LG", "Samsung");
    }
}