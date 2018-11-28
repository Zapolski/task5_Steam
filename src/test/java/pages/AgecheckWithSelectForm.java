package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class AgecheckWithSelectForm {

    BaseElement selectItem = new BaseElement(By.xpath("//*[@id='ageYear']"));
    BaseElement openProductButton = new BaseElement(By.xpath("//*[@onclick='ViewProductPage()']"));

    private final String yearForConfirm = "1984";

    public void confirm(){
        Select select = new Select(selectItem.getElement());
        select.selectByValue(yearForConfirm);
        openProductButton.click();
    }
}
