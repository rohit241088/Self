package uiAutomation.uiUtils;

import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UIUtils {

    public static void clickElement(WebElement element, WebDriverWait wait, JavascriptExecutor js) {
        try {
            element.click();
        } catch (ElementClickInterceptedException ex) {
            js.executeScript("arguments[0].click();", element);
        } catch (ElementNotInteractableException ex) {
            System.out.println("Element not interactable "+element.getTagName());
        } catch (NoSuchElementException ex) {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        }

    }

    public static boolean verifyUIElementTextContainsSearchValue(WebElement element, String searchValue, Scenario sc){
        String[] values=element.getText().split(" ");
        String updatedValue="";
        for(String val:values){
            updatedValue=updatedValue+val;
        }
        updatedValue=updatedValue.toUpperCase();
        sc.log(updatedValue+" is element text");

        String[] searchvalues=searchValue.split(" ");

        for(int i=0;i<searchvalues.length;i++){
            searchvalues[i]=searchvalues[i].toUpperCase();
        }
        boolean match=false;
        for(String s:searchvalues){
            sc.log("Checking match againt element text "+updatedValue+" against search value "+s);
            if(updatedValue.contains(s)){
                match=true;
                break;
            }
        }
        return match;

    }

}
