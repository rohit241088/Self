package uiAutomation.baseTest.hooks;

import uiAutomation.baseTest.BaseTest;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

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
