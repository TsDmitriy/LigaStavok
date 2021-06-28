package org.example.ligastavok;

import org.junit.jupiter.api.Test;
import org.example.ligastavok.pages.MainPage;

public class CheckFilterPriceAndBrandTest extends BaseTest {

    @Test
    public void test() {
        mainPage.goToElectronicsPage()
                .goToTvSetPage()
                .selectMinPrice("20000")
                .selectBrandTvSet("LG")
                .selectBrandTvSet("Samsung")
                .chooseFirstTvSet()
                .checkPriceTvMoreOrEqual(20000)
                .checkBrandTvEqual("LG", "Samsung");
    }
}