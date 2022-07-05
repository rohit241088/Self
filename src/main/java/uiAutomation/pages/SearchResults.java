package uiAutomation.pages;

import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import uiAutomation.BaseClass.UIBaseClass;
import static uiAutomation.uiUtils.UIUtils.*;

import java.util.Arrays;
import java.util.List;

public class SearchResults extends UIBaseClass {
    public SearchResults(WebDriver driver) {
        super(driver);
    }


    public List<WebElement> searchResults(){
        return driver.findElements(By.xpath(pageObjects.get("searchResults").split("@@@")[1]));
    }

    public void verifySearch(String searchValue, SoftAssert softAssert,Scenario sc){
        searchResults().forEach((ele)->{

            softAssert.assertTrue(verifyUIElementTextContainsSearchValue(ele,searchValue,sc));
        });
        softAssert.assertAll();
    }



}
