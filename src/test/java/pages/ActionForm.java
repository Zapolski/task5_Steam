package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ActionForm {

    public BaseElement topSellers = new BaseElement(By.xpath("//*[@id='tab_select_TopSellers']"));
    private By discountListLocator = By.xpath("//*[@id='TopSellersRows']//*[@class='discount_pct']");

    private int discountMaxTopSellser = Integer.MIN_VALUE;

    public int getDiscountMaxTopSellser() {
        return discountMaxTopSellser;
    }

    public WebElement getElementWithMaxDiscount(){
        List<WebElement> listDiscounts = (new BaseElement(discountListLocator)).getBaseElementList();

        //находми первую игру с максимальной скидкой и кликаем по ней
        WebElement elementWithMaxDiscount = listDiscounts.get(0);
        discountMaxTopSellser = Integer.parseInt(elementWithMaxDiscount.getText().substring(1,3));
        for (WebElement el : listDiscounts){
            int discount = Integer.parseInt(el.getText().substring(1,3));
            if (discount>discountMaxTopSellser){
                elementWithMaxDiscount=el;
                discountMaxTopSellser=discount;
            }
        }
        return elementWithMaxDiscount;
    }

}
