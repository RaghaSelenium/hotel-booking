package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by raghavendra on 22/04/18.
 */
public  class Base {

    public Base(WebDriver driver){
        PageFactory.initElements(driver,this);

    }




}
