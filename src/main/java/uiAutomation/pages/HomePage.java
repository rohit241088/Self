package uiAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import uiAutomation.BaseClass.UIBaseClass;

public class HomePage extends UIBaseClass {

    public HomePage(WebDriver driver) {
        super(driver);
           }

public WebElement SearchField(){
        return driver.findElement(By.xpath(pageObjects.get("searchField").
                split("@@@")[1]));
}

public SearchResults searchForValue(String valueToSearch){
        SearchField().sendKeys(valueToSearch);
    SearchField().sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
    return super.getPage(SearchResults.class);
    }


}
