package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationMenu extends BasePage {

    // Elements
    @FindBy(xpath = "//a[contains(text(), 'טיסות לחו\"ל')]")
    private WebElement flightsTab;

    // Constructor
    public NavigationMenu(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    // Methods
    /**
     * Opens the flights tab where users can search for available flights.
     */
    public void openFlightsTab() {
        click(flightsTab);
    }
}