package baseTest;

import generalUtils.PropertiesHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;
import uiAutomation.BaseClass.UIBaseClass;
import uiAutomation.UIAutomationInstance.UIPage;

import java.time.Duration;

public class BaseTest {
    public static UIPage page;
    public static WebDriver driver;
    public static ThreadLocal<WebDriver>driverThreadLocal;
    public static PropertiesHelper configproperties;
    public static SoftAssert softAssert=null;

    public static void setupTest(){
        configproperties=new PropertiesHelper(System.getProperty("user.dir")+
                PropertiesHelper.getBaseConfig().getProperty("UIConfigPropertiesPath"));
        switch (configproperties.properties.getProperty("browser")){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
                break;
        }

        driver.get(configproperties.properties.getProperty("url"));
        softAssert=new SoftAssert();
        page=new UIBaseClass(driver);
    }


    public static void multiThreadsetupTest(){
             configproperties=new PropertiesHelper(System.getProperty("user.dir")+
                PropertiesHelper.getBaseConfig().getProperty("UIConfigPropertiesPath"));
        switch (configproperties.properties.getProperty("browser")){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                driverThreadLocal.set(driver);
                driverThreadLocal.get().manage().window().maximize();
                driverThreadLocal.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
                break;
        }

        driverThreadLocal.get().get(configproperties.properties.getProperty("url"));
        softAssert=new SoftAssert();
        page=new UIBaseClass(driverThreadLocal.get());
    }

    public static void threadedDriverTearDown(){
        driverThreadLocal.get().close();
    }

    public static void tearDown(){
        driver.close();
    }
}
