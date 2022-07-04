package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

@RunWith(Cucumber.class)
    @CucumberOptions(
            features = "features"
            ,glue={"stepDefinitions","hooks"},
         plugin =   {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
           monochrome = true,
            tags = "@Multithreaded"
    )
    public class RunnerClass {

}
