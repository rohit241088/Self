package uiAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import uiAutomation.BaseClass.UIBaseClass;

import java.util.List;

public class SearchResults extends UIBaseClass {
    public SearchResults(WebDriver driver) {
        super(driver);
    }


    public List<WebElement> searchResults(){
        return driver.findElements(By.xpath(pageObjects.get("searchResults").split("@@@")[1]));
    }


    public boolean validateSearchResults(String searchString){
        return searchResults().stream().allMatch((s)->{
            System.out.println("Get text value "+s.getText()+" against search value "+searchString);
              return s.getText().toUpperCase().contains(searchString.toUpperCase());

                });

    }

}
