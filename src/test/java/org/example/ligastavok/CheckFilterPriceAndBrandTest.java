package org.example.ligastavok;

import org.junit.jupiter.api.Test;
import org.example.ligastavok.pages.MainPage;

public class CheckFilterPriceAndBrandTest extends BaseTest {

    @Test
    public void test() {
        new MainPage()
                .goToElectronicsPage()
                .goToTvSetPage()
                .selectMinPriсe("20000")
                .selectBrandTvSet("LG")
                .selectBrandTvSet("Samsung")
                .chooseFirstTvSet()
                .checkPriсeTvMoreOrEqual(20000)
                .checkBrandTvEqual("LG", "Samsung");
    }
}