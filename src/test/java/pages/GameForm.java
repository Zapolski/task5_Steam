package pages;

import org.openqa.selenium.By;

public class GameForm {

    private BaseElement checkDiscountEl = new BaseElement(By.xpath("//*[@id='game_area_purchase']//*[@class='discount_pct']"));

    public int getActualDiscount() {
        return Integer.parseInt(checkDiscountEl.getElement().getText().substring(1,3));
    }
}
