package org.example.ligastavok;

import org.example.ligastavok.driver.Driver;
import org.example.ligastavok.pages.BasePage;
import org.example.ligastavok.pages.MainPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    protected static MainPage mainPage;

    @BeforeAll
    public static void startDriver() {
        mainPage= new BasePage().goToMainPage();

    }
    @AfterAll
    public static void stopDriver() {
        Driver.stopDriver();

    }
}
