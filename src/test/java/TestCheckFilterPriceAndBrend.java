import Pages.MainPage;

import java.io.IOException;

public class TestCheckFilterPriceAndBrend extends TestBase{

    @org.junit.jupiter.api.Test

    public void test() throws IOException {
       new MainPage()
                .goToElektronikaPage()
                .goToTvSetPage()
                .selectMinPrise("20000")
                .selectBrendTVset("LG")
                .selectBrendTVset("Samsung")
                .choiseFirstTvSet()
                .checkPriseTvMoreOrEqual(20000)
                .checkBrendTvEqual("LG","Samsung");
    }
}