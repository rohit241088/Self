package hooks;

import baseTest.BaseTest;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import generalUtils.PropertiesHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.jsoup.Connection;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import uiAutomation.UIAutomationInstance.UIPage;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class baseHooks {


    @Before
    public void initiate(){
        BaseTest.setupTest();
    }


    @After
    public void tearDown(Scenario sc){
if(sc.isFailed()){
    String bytes=((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.BASE64);
    //sc.attach(bytes,"screenshot",sc.getName());
    try {
        ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(bytes);
        sc.log("screenshot");
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}
        BaseTest.tearDown();
    }


}
