package pages;

import org.openqa.selenium.By;

public class AgecheckForm {

    //https://store.steampowered.com/app/552500/agecheck
    private BaseElement openProductButton = new BaseElement(By.xpath("//*[starts-with(@onclick,'HideAgeGate')]"));

    public void confirm(){
        openProductButton.click();
    }
}
