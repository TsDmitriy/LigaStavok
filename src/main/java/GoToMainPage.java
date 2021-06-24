import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class GoToMainPage {
    private String url = "https://market.yandex.ru/";

    /**
     * Метод осуществляет переход на главную страницу приложения
     * @return новую страницу MainPage
     */
    public MainPage goToMainPage() throws IOException {
        Driver.getInstance().get(url);
        Helpers.getScreenshotAs();
        return new MainPage();
    }

}
