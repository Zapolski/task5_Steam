import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SubTabs;
import pages.Tabs;

import java.io.*;

public class OpenPageTest extends BaseTest{

    @Test
    public void downloadTopActionWhitMaxDiscount(){
        //наводим мышкой на игры
        Actions builder = new Actions(driver);
        builder.moveToElement(indexForm.menu.selectItem(Tabs.GENRE).getElement()).build().perform();

        //кликаем по экшен
        indexForm.menu.selectSubItem(SubTabs.ACTION).click();

        //переходим на вкладку лидеры продаж
        actionForm.topSellers.click();

        //кликаем по игре с максимальной скидкой
        actionForm.getElementWithMaxDiscount().click();

        //подтверждаем возраст
        confirmAge();

        //проверяем скидку
        Assert.assertEquals(gameForm.getActualDiscount(),actionForm.getDiscountMaxTopSellser());

        //переход по ссылке install steam
        indexForm.menu.installSteam.click();

        //кликаем для скачивания
        installSteamForm.installSteam.click();

        //ждем закачки файла
        sleep(5000);

        //проверяем наличие файла
        fileActual = initFileByURL(installSteamForm.installSteam.getElement().getAttribute("href"));
        Assert.assertTrue(fileActual.exists());
    }

    private void sleep(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void confirmAge(){
        //выбираем страницу подтверждения возраста по положению "agecheck" в URL страницы
        //https://store.steampowered.com/agecheck/app/271590/ - с селектом
        //https://store.steampowered.com/app/552500/agecheck  - без селекта
        String current_page = driver.getCurrentUrl();
        int index = current_page.indexOf("agecheck");
        if (index>0){
            if (index==31){
                agecheckWithSelectForm.confirm();
            }else{
                agecheckForm.confirm();
            }
        }
    }

    private File initFileByURL(String url){
        String fileName = url.substring(url.lastIndexOf("/")+1);
        return new File(outputFilePath+fileName);
    }





}
