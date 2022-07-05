package hooks;

import baseTest.BaseTest;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import generalUtils.PropertiesHelper;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.messages.types.Step;
import io.cucumber.plugin.event.StepDefinedEvent;
import io.cucumber.plugin.event.StepDefinition;
import org.jsoup.Connection;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import uiAutomation.UIAutomationInstance.UIPage;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class baseHooks {

public static Scenario sc;


//@AfterStep
//public void afterEach(StepDefinedEvent S){
//    sc.log(S.getStepDefinition()..getPattern());
//}
    @Before
    public void initiate(Scenario sc){
        baseHooks.sc=sc;
        sc.log("Initiating test case "+sc.getName());
        BaseTest.setupTest();
    }


    @After
    public void tearDown(Scenario sc){
        sc.log("Closing up test case "+sc.getName());
if(sc.isFailed()){
    sc.log("test case "+sc.getName()+" is failed");
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
