package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage extends BasePage {

    // Elements
    @FindBy(id = "checkoutTotal")
    private WebElement checkoutPrice;

    @FindBy(xpath = "//span[@class = 'price']//small")
    private WebElement currencySymbol;

    // Constructor
    public CheckoutPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    // Methods
    /**
     * Retrieves the total checkout price, including the currency symbol.
     * @return A string representing the total price at checkout.
     */
    public String getCheckoutPrice() {
        return getText(currencySymbol) + getText(checkoutPrice);
    }
}