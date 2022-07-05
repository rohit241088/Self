package uiAutomation.baseTest.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
    @CucumberOptions(
            features = "uiFeatures"
            ,glue={"uiAutomation/baseTest/stepDefinitions", "uiAutomation/baseTest/hooks"},
         plugin =   {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
           monochrome = true,
            tags = "@Multithreaded"
    )
    public class RunnerClass {

}
