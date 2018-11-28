import drivers.PropertiesConfigManager;
import drivers.WebDriverSingl;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;
    public WebDriverSingl webDriverSingl;
    public PropertiesConfigManager prop;

    public IndexForm indexForm;
    public InstallSteamForm installSteamForm;
    public ActionForm actionForm;
    public AgecheckForm agecheckForm;
    public AgecheckWithSelectForm agecheckWithSelectForm;
    public GameForm gameForm;

    File fileActual;

    String testURL = "";
    String testBrowser = "";
    String outputFilePath = "";
    String language = "";

    private static final int TIMEOUT_WAIT = 15;


    @BeforeTest
    public void setUp(){
        prop = new PropertiesConfigManager("config.properties");
        testURL = prop.getProperty("URL");
        testBrowser = prop.getProperty("BROWSER");
        outputFilePath = prop.getProperty("OUTPUT_FILE_PATH");
        language= prop.getProperty("LANGUAGE");

        // инициализируем драйвер
        webDriverSingl = WebDriverSingl.getInstance(testBrowser);
        driver = webDriverSingl.driver;

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(TIMEOUT_WAIT, TimeUnit.SECONDS);

        indexForm = new IndexForm();
        installSteamForm = new InstallSteamForm();
        actionForm = new ActionForm();
        agecheckForm = new AgecheckForm();
        agecheckWithSelectForm = new AgecheckWithSelectForm();
        gameForm = new GameForm();

        driver.get(testURL);
    }

    @AfterTest
    public void tearDown(){
        if (fileActual!=null){
            fileActual.delete();
        }
        if(driver != null)
            driver.quit();
    }

}
