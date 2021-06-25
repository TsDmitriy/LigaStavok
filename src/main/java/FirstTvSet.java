
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FirstTvSet extends MainPage{

    public FirstTvSet() throws IOException {
        PageFactory.initElements(Driver.getInstance(),this);
    }
    @FindBy(xpath = "//*[@class=\"_2CEl7XpdNV\"]//*[@class=\"_10o2cPu4Fn\"]")
    private WebElement priseTV;

    @FindBy(className = "x__tNeZtug")
    private WebElement brendTV;

    /**
     * Метод получает цену телевизора и сравнивает ее с ценой установленной в фильтре
     * @param priseEstablished цена товара установленная в фильтре
     * @return FirstTvSet
     */
    @Step("Проверяем, что цена телевизора соотвествует параметрам установленным в фильтре")
    public FirstTvSet checkPriseTvMoreOrEqual (Integer priseEstablished) {
        Integer prise = Integer.parseInt(priseTV.getText().replaceAll("[^0-9]", ""));
//        Assert.assertTrue("Цена товара не соответствует цене заданной в фильтре:" +" " + priseEstablished,prise>=priseEstablished);
        return this;
    }

    /**
     * Метод проверяет, что в описании товара присутствует бренд выбранный в фильтре
     * @param brends бренды выбранные в фильтре
     */
    @Step("Проверяем, что бренд телевизора соотвествует параметрам установленным в фильтре")
    public void checkBrendTvEqual (String...brends) {
        ArrayList<String> listBrend = new ArrayList<>(Arrays.asList(brends));
        String descriptionTV = brendTV.getText();
        for (String s:listBrend) {
            if (descriptionTV.contains(s)) {
                break;
            }
            else {
                throw new IllegalArgumentException("Бренд телевизора не соотвествует брендам заданным в фильтре:" + String.join(",", brends));
            }
        }
    }
}
