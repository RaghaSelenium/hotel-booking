package stepDefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

/**
 * Created by raghavendra on 22/04/18.
 */
public class Hooks {
    public static WebDriver driver;
    public static String driverPath = null ;
    String userDirectory =  System.getProperty("user.dir");


    @Before
    /**
     * Delete all cookies at the start of each scenario to avoid
     * shared state between tests
     */
    public void openBrowser() throws MalformedURLException {

        initialiseBrowser("chrome");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }
    public void initialiseBrowser(String browser) {

        if (browser.equalsIgnoreCase("CHROME")) {
            System.out.println("************************");
            System.setProperty("webdriver.chrome.driver","/usr/lib/chromium-browser/chromedriver");
            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("IE")) {
            driver = new InternetExplorerDriver();

        } else if (browser.equalsIgnoreCase("FIREFOX")) {
            System.out.println("*******************************");
//            System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/src/test/resources/dependencies/geckodriver");
            System.setProperty("webdriver.gecko.driver",userDirectory + "/src/test/resources/dependencies/geckodriver");
            driver = new FirefoxDriver();

        }
    }



//    }


    @After
    public void embedScreenshot(Scenario scenario) {

        if(scenario.isFailed()) {
            try {
                scenario.write("Current Page URL is " + driver.getCurrentUrl());
                byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException e) {
                System.err.println(e.getMessage());
            }

        }
        driver.quit();

    }
}
