package drivers;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverSingl {

    private static WebDriverSingl instance;
    private static final String PATH_DRIVER_CHROME = "./src/test/resources/chromedriver.exe";
    private static final String PATH_DRIVER_FIREFOX = "./src/test/resources/geckodriver.exe";
    private static final String PATH_DRIVER_IEXPLORE = "./src/test/resources/IEDriverServer.exe";

    private static final String NAME_DRIVER_CHROME = "webdriver.chrome.driver";
    private static final String NAME_DRIVER_FIREFOX = "webdriver.gecko.driver";
    private static final String NAME_DRIVER_IEXPLORE = "webdriver.ie.driver";

    public static String current_browser = "";
    public static WebDriver current_driver = null;

    public WebDriver driver;

    PropertiesConfigManager prop;

    private WebDriverSingl(){
    }

    public static WebDriverSingl getInstance(String type){

        if (instance==null){

            Browsers typeBrowser = null;
            for (Browsers br : Browsers.values()) {
                if (br.toString().equalsIgnoreCase(type)) {
                    typeBrowser = br;
                }
            }

            if (typeBrowser!=null){
                instance = new WebDriverSingl();
                current_browser=typeBrowser.toString();
                instance.prop = new PropertiesConfigManager("config.properties");

                switch (typeBrowser) {
                    case CHROME:
                        System.setProperty(NAME_DRIVER_CHROME,PATH_DRIVER_CHROME);
                        instance.driver = new ChromeDriver();
                        break;
                    case FIREFOX:
                        //eager – ждать, пока свойство document.readyState примет значение interactive
                        FirefoxOptions opt = new FirefoxOptions();
                        opt.setPageLoadStrategy(PageLoadStrategy.EAGER);

                        FirefoxProfile profile = new FirefoxProfile();
                        profile.setPreference("browser.helperApps.neverAsk.saveToDisk" , "application/octet-stream;application/csv;text/csv;application/vnd.ms-excel;");
                        profile.setPreference("browser.helperApps.alwaysAsk.force", false);
                        profile.setPreference("browser.download.manager.showWhenStarting",false);
                        profile.setPreference("browser.download.folderList", 2);
                        profile.setPreference("browser.download.dir",instance.prop.getProperty("OUTPUT_FILE_PATH"));
                        opt.setProfile(profile);

                        System.setProperty(NAME_DRIVER_FIREFOX,PATH_DRIVER_FIREFOX);
                        instance.driver = new FirefoxDriver(opt);
                        break;
                    case IEXPLORE:
                        System.setProperty(NAME_DRIVER_IEXPLORE,PATH_DRIVER_IEXPLORE);
                        instance.driver = new InternetExplorerDriver();
                        break;
                }
            }else{
                System.out.println("Некорректное/неподдерживаемое имя браузера! Драйвер не инициализрован!");
                return null;
            }
            current_driver = instance.driver;
        }

        return instance;
    }
}
