import java.io.IOException;

public class Test extends TestBase{

    @org.junit.Test

    public void test() throws IOException {
       new MainPage()
                .goToElektronikaPage();
//                .goToTvSetPage()
//                .selectMinPrise("20000")
//                .selectBrendTVset("LG")
//                .selectBrendTVset("Samsung")
//                .choiseFirstTvSet()
//                .checkPriseTvMoreOrEqual(20000)
//                .checkBrendTvEqual("LG","Samsung");
    }
}