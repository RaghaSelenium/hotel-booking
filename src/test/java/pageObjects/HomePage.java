package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import stepDefinitions.Hooks;
import util.WebUtil;

import java.util.HashMap;
import java.util.List;

/**
 * Created by raghavendra on 22/04/18.
 */
public class HomePage extends Base {

    public String customerXpathBuilder;
    private WebDriver driver = Hooks.driver;

    @FindBy(id = "firstname")
    private WebElement firstName;

    @FindBy(id = "lastname")
    private WebElement surname;

    @FindBy(id = "totalprice")
    private WebElement price;

    @FindBy(id = "depositpaid")
    private WebElement deposit;

    @FindBy(id = "checkin")
    private WebElement checkIn;

    @FindBy(id = "checkout")
    private WebElement checkOut;

    @FindBy(xpath = ".//input[contains(@value,'Save')]")
    private WebElement saveButton;

    public HomePage(WebDriver driver) {
        super(driver);

    }

    /* this method finds and returns the booking details row of a specific customer
    by first name (customerXpathBuilder) as there might be multiple customer records in the UI*/
    private List<WebElement> bookingDetailsList() {
        String userDetailsIdentifier = ".//p[contains(text(),'" + customerXpathBuilder + "')]/../..//div/p";
        return driver.findElements(By.xpath(userDetailsIdentifier));
    }

    /* this method returns the delete button that is attached to a particular customer detail by
    first name (customerXpathBuilder)  */
    public WebElement deleteButtonAttachedToCustomerRecord() {
        String userDetailsIdentifier = ".//p[contains(text(),'" + customerXpathBuilder + "')]/../..//div[7]";
        WebElement element;
        try {
            element = driver.findElement(By.xpath(userDetailsIdentifier));
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            element = null;
            return element;
        }
        return element;
    }

    public void enterFirstName(String firstName) {

        WebUtil.typeIntoTextField(this.firstName, firstName);
    }

    public void enterSurname(String str) {

        WebUtil.typeIntoTextField(surname, str);

    }

    public void enterPrice(String str) {

        WebUtil.typeIntoTextField(price, str);
    }

    public void enterCheckIn(String str) {

        WebUtil.typeIntoTextField(checkIn, str);
    }

    public void enterCheckOut(String str) {

        WebUtil.typeIntoTextField(checkOut, str);
    }

    public void clickSaveButton() {
        saveButton.click();
    }

    public void selectDepositOption(String option) {
        WebUtil.selectDropdown(deposit, option);
    }

    public HashMap<String, String> getActualBookingData() throws InterruptedException {
        List<WebElement> bookedInDetailRow = bookingDetailsList();

        HashMap<String, String> actualDetails = new HashMap<String, String>();

//         assertThat(bookingDetailsList().size(), is(equalTo(6)));
        actualDetails.put("firstName", bookedInDetailRow.get(0).getText());
        actualDetails.put("surName", bookedInDetailRow.get(1).getText());
        actualDetails.put("price", bookedInDetailRow.get(2).getText());
        actualDetails.put("deposit", bookedInDetailRow.get(3).getText());
        actualDetails.put("checkIn", bookedInDetailRow.get(4).getText());
        actualDetails.put("checkOut", bookedInDetailRow.get(5).getText());
        return actualDetails;
    }

    public void deleteCustomerBooking() {

        deleteButtonAttachedToCustomerRecord().click();

    }
}
