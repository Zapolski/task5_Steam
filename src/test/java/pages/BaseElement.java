package pages;

import drivers.WebDriverSingl;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseElement {

    private WebDriver driver;
    private WebDriverWait wait;
    private WebElement element=null;
    private List<WebElement> elementList;
    private By locator;


    public BaseElement(By locator){
        driver= WebDriverSingl.current_driver;
        wait = new WebDriverWait(driver,10);
        this.locator=locator;
    }

    public void click(){
        waitAndFindElement();
        element.click();
    }

    public WebElement getElement(){
        waitAndFindElement();
        return element;
    }

    public List<WebElement> getBaseElementList() {
        waitAndFindElements();
        return elementList;
    }

    private void waitAndFindElement(){
        element = wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    private void waitAndFindElements(){
        elementList = driver.findElements(locator);
    }
}
