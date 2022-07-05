package hooks;

import baseTest.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import generalUtils.PropertiesHelper;
import io.cucumber.java.*;
import io.cucumber.messages.types.Step;
import io.cucumber.plugin.event.StepDefinedEvent;
import io.cucumber.plugin.event.StepDefinition;
import junit.framework.TestResult;
import org.jsoup.Connection;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import org.testng.junit.JUnitTestRunner;
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
        byte[] bytes=((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.BYTES);
sc.attach(bytes,"",sc.getName());

        BaseTest.tearDown();
    }


}
