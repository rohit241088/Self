package threadSafety;

import org.openqa.selenium.WebDriver;

public class WebDriverThread extends Thread{

    private WebDriver driver;
    @Override
    public void run(){
this.setDriver(driver);
    }
    public WebDriver returnDriver(){
    return this.driver;
    }

public void setDriver(WebDriver driver){
        this.driver=driver;
}

}
