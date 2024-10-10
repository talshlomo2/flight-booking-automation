package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FlightDetailsPage extends BasePage {

    // Element
    @FindBy(xpath = "//button[text() = 'המשך']")
    private WebElement continueButton;

    @FindBy(id = "_ZAbanner_CLOSE_BUTTON")
    private WebElement closePrivacyMessageButton;

    // Constructor
    public FlightDetailsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    // Methods
    /**
     * Clicks the continue button to proceed to the checkout page.
     * Closes the privacy message first, as it can sometimes hide the button.
     */
    public void clickContinue() {
        click(closePrivacyMessageButton);
        click(continueButton);
    }
}