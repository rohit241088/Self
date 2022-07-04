package stepDefinitions;

import baseTest.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import uiAutomation.pages.HomePage;
import uiAutomation.pages.SearchResults;

import java.util.List;

public class GoogleHomePage extends BaseTest {
    SearchResults searchResults=null;
    @Given("User is on home page")
    public void user_is_on_home_page() {
        // Write code here that turns the phrase above into concrete actions

    }
    @When("Searches for {string}")
    public void searches_for(String string) {
        // Write code here that turns the phrase above into concrete actions
       searchResults=page.getPage(HomePage.class).searchForValue(string);
           }
    @Then("each search results should contain {string}")
    public void each_search_results_should_contain(String string) {
        // Write code here that turns the phrase above into concrete actions
        List<WebElement> allResults=searchResults.searchResults();
for(int i=0;i<allResults.size();i++){
        softAssert.assertTrue(allResults.get(i).getText().toUpperCase().contains(string.toUpperCase()));
    System.out.println("Matching "+allResults.get(i).getText().toUpperCase()+" against search value "+string.toUpperCase());
}
softAssert.assertAll();
    }
}