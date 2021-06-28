package org.example.ligastavok;

import org.example.ligastavok.driver.Driver;
import org.example.ligastavok.pages.BasePage;
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
