package pages;

import drivers.PropertiesConfigManager;
import org.openqa.selenium.By;

public class Menu {

    private final String PATH_START_ITEM="//*[@id='";
    private final String PATH_END_ITEM="']";

    private final String PATH_START_SUBITEM="//a[@class='popup_menu_item'][contains(text(),'";
    private final String PATH_END_SUBITEM="')]";

    PropertiesConfigManager prop;

    Language currentLanguage;

    public BaseElement installSteam  = new BaseElement(By.xpath("//*[@class='header_installsteam_btn_content']"));

    public Menu(){
        //получаем текущий язык тестирования
        prop = new PropertiesConfigManager("config.properties");
        String langStr = prop.getProperty("LANGUAGE");
        for (Language ln : Language.values()) {
            if (ln.toString().equalsIgnoreCase(langStr)) {
                currentLanguage = ln;
            }
        }
    }

    //доступ к основному меню
    public BaseElement selectItem(Tabs tab){
        return new BaseElement(By.xpath(PATH_START_ITEM+tab.toString()+PATH_END_ITEM));
    }

    //доступ к элементам подменю без привязки к основному
    public BaseElement selectSubItem (SubTabs subTab){
        String subItem = subTab.getValue(currentLanguage);
        return new BaseElement(By.xpath(PATH_START_SUBITEM+subItem+PATH_END_SUBITEM));
    }

}


