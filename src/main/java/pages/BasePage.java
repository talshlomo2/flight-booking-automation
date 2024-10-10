package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BasePage {

    /**
     * BasePage serves as a foundational class for page objects in the Page Object Model.
     * It provides common methods for interacting with web elements, including tab switching.
     */

    // Variables
    protected final WebDriver driver;
    protected final WebDriverWait wait;

    // Constructor
    /**
     * Initializes the BasePage with a WebDriver and WebDriverWait.
     * Also initializes the page elements using PageFactory.
     * @param driver The WebDriver instance.
     * @param wait The WebDriverWait instance.
     */
    protected BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    // Methods
    /**
     * Common interaction methods for web elements, ensuring each element
     * is in an appropriate state before interacting.
     */

    protected void click(WebElement element) {
        waitForElementToBeClickable(element);
        element.click();
    }

    protected void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void enterText(WebElement element, String text) {
        waitForElementToBeClickable(element);
        element.sendKeys(text);
    }

    protected void clearText(WebElement element) {
        waitForElementToBeClickable(element);
        element.clear();
    }

    protected String getText(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    private void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Switches to the specified browser tab index and waits for the tab to be available before switching.
     * @param tabNum The index of the tab to switch to.
     */
    protected void switchTab(int tabNum) {
        wait.until(ExpectedConditions.numberOfWindowsToBe(tabNum + 1));
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabNum));
    }
}