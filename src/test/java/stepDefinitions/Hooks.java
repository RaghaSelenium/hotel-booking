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
    private static String userDirectory = System.getProperty("user.dir");
    private String desiredBrowser = (System.getProperty("browser") != null) ? System.getProperty("browser") : "";


    @Before
    /**
     * Delete all cookies at the start of each scenario to avoid
     * shared state between tests
     */
    public void openBrowser() throws MalformedURLException {

        System.out.println(desiredBrowser);

        initialiseBrowser(desiredBrowser);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    public void initialiseBrowser(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                setChromePathAsPerOS();
                driver = new ChromeDriver();
                break;
            case "firefox":
                // set the system property for firefox
                System.setProperty("webdriver.gecko.driver", "/home/developer/projects/hotel-booking/src/test/resources/dependencies/geckodriver");
                driver = new FirefoxDriver();
                break;
            case "ie":
                // set the system property for IE
                driver = new InternetExplorerDriver();
                break;
            default:
                setChromePathAsPerOS();
                driver = new ChromeDriver();
        }

    }

    /* Currently supports Linux and Mac chromedriver */
    private static void setChromePathAsPerOS(){
        if(System.getProperty("os.name").equalsIgnoreCase("Linux")){
            System.setProperty("webdriver.chrome.driver", userDirectory + "/src/test/resources/dependencies/chromedriver");
        }else {
            System.setProperty("webdriver.chrome.driver", userDirectory + "/src/test/resources/dependencies/chromedriverForMac");

        }
    }


    @After
    public void embedScreenshot(Scenario scenario) {

        if (scenario.isFailed()) {
            try {
                scenario.write("Current Page URL is " + driver.getCurrentUrl());
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException e) {
                System.err.println(e.getMessage());
            }

        }
        driver.quit();

    }
}
