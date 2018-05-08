package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

/**
 * Created by raghavendra on 22/04/18.
 */
public class WebUtil {

    public static void typeIntoTextField(WebElement element, String text){
        element.sendKeys(text);
    }

    public static int randomNumGenerator() {
        Random r = new Random( System.currentTimeMillis() );
        return 10000 + r.nextInt(20000);
    }

    public static void selectDropdown(WebElement element, String value){
            Select drpCountry = new Select(element);
            drpCountry.selectByVisibleText(value);
        }

    public static String getProperty(String key) throws IOException {
        String propertyFilePath = "/home/developer/projects/hotel-booking/src/test/resources/configs/Configuration.properties";
        BufferedReader reader = new BufferedReader(new FileReader(propertyFilePath));
        Properties properties = new Properties();
        properties.load(reader);
        String value = properties.getProperty(key);

        return value;

    }

}
