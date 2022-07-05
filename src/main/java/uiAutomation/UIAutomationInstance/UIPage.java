package uiAutomation.UIAutomationInstance;


import generalUtils.PropertiesHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import uiAutomation.BaseClass.UIBaseClass;

import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class UIPage {

    public WebDriver driver;
    public WebDriverWait wait;
public Map<String,String> pageObjects=null;
public JavascriptExecutor js;
   public UIPage(WebDriver driver){
        this.initiateUIAutomationInstance();
        this.driver=driver;
        js=(JavascriptExecutor)driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(30));
    }
     public void initiateUIAutomationInstance() {
        Properties properties=null;
      PropertiesHelper propertiesHelper=new PropertiesHelper(System.getProperty("user.dir")+
              PropertiesHelper.getBaseConfig().getProperty("UIConfigPropertiesPath"));
      properties=propertiesHelper.properties;
      pageObjects=new HashMap<>();
      for(Object k:properties.keySet()){
          pageObjects.put((String)k,(String)properties.getProperty((String)k));
      }
    }

    public <T extends UIBaseClass> T getPage(Class<T>clas){
        try {
            return clas.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }



//   public boolean validateElementTextMatching(String expected, WebElement element){
//     return element.getText().compareTo(expected)==0;
//   }
//






}
