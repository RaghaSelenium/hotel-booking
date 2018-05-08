package stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;
import util.WebUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by raghavendra on 22/04/18.
 */
public class HomePageFeatureSteps {
    public static String customerFirstName = null;
    List<List<String>> customerDetails;
    HashMap<String, String> expectedUserDetails = new HashMap<String, String>();
    private WebDriver driver = Hooks.driver;
    HomePage homePage = new HomePage(driver);

    @Given("^I am on \"(.*?)\" page$")
    public void i_am_on_page(String pageTitle) throws IOException {
        driver.get(WebUtil.getProperty("url"));

        assertThat(driver.getTitle(), is(equalTo(pageTitle)));

    }

    @When("^I book with below customer details$")
    public void iBookWithBelowCustomerDetails(DataTable dataTable) throws Throwable {

        customerDetails = dataTable.raw();

        customerFirstName = "Stuart" + WebUtil.randomNumGenerator();

//        this customerXpathBuilder is used to obtain accurate user record
        homePage.customerXpathBuilder = customerFirstName;

        homePage.enterFirstName(customerFirstName);
        homePage.enterSurname(customerDetails.get(2).get(1));
        homePage.enterPrice(customerDetails.get(3).get(1));
        homePage.selectDepositOption(customerDetails.get(4).get(1).toLowerCase());
        homePage.enterCheckIn(customerDetails.get(5).get(1));
        homePage.enterCheckOut(customerDetails.get(6).get(1));
        homePage.clickSaveButton();

        driver.navigate().refresh();
    }


    @Then("^I can see customer details are added to the list$")
    public void iCanSeeCustomerDetailsAreAddedToTheList() throws InterruptedException {

        HashMap<String, String> actualDetails = homePage.getActualBookingData();

        driver.navigate().refresh();

        assertThat(actualDetails.get("firstName"), is(equalTo(customerFirstName)));
        assertThat(actualDetails.get("surName"), is(equalTo(customerDetails.get(2).get(1))));
        assertThat(actualDetails.get("price"), is(equalTo(customerDetails.get(3).get(1))));
        assertThat(actualDetails.get("deposit"), is(equalTo(customerDetails.get(4).get(1))));
        assertThat(actualDetails.get("checkIn"), is(equalTo(customerDetails.get(5).get(1))));
        assertThat(actualDetails.get("checkOut"), is(equalTo(customerDetails.get(6).get(1))));
    }

    @Given("^I have customer details to delete the booking$")
    public void i_have_customer_details_to_delete_the_booking() {

        homePage.customerXpathBuilder = customerFirstName;

    }

    @When("^I delete the booking$")
    public void i_delete_the_booking() {

        homePage.deleteCustomerBooking();

        driver.navigate().refresh();


    }

    @Then("^I can see no booking for the customer$")
    public void i_can_see_no_booking_for_the_customer() {

        //verify user details doesn't exist
        Assert.assertNull(homePage.deleteButtonAttachedToCustomerRecord());

    }


}

