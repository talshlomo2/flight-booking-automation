package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {

    /**
     * BaseTest class manages the WebDriver for the tests using TestNG.
     * It handles browser initialization and cleanup.
     */

    private final static int WAIT_TIMEOUT = 20;
    protected WebDriver driver;
    protected WebDriverWait wait;

    // Set up ChromeDriver
    static {
        WebDriverManager.chromedriver().setup();
    }

    /**
     * Initializes the WebDriver and prepares the browser environment before running tests.
     * @param url The URL to open in the browser.
     */
    @BeforeTest
    @Parameters("url")
    protected void initialize(String url) {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT));
        driver.get(url);
        driver.manage().window().maximize();
    }

    /**
     * Cleans up the WebDriver session after tests.
     */
    @AfterTest
    protected void terminate() {
        driver.quit();
    }
}