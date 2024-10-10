package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;

public class FlightSearchPage extends BasePage {

    // Elements
    @FindBy(xpath = "//input[@placeholder = 'בחר מוצא']")
    private WebElement departureInput;

    @FindBy(xpath = "//input[@placeholder = 'לאיפה?']")
    private WebElement destinationInput;

    @FindBy(id = "start_date")
    private WebElement dateInput;

    @FindBy(xpath = "//button[text() = 'חפשו']")
    private WebElement searchButton;

    // Locators
    private final static String DAY_BUTTON_CALENDAR = "//th[@class = 'month-name' and text()='%s']//ancestor::table" +
            "//span[@class = 'day-number' and text()='%s']";
    private final static By FLIGHTS_LIST = By.xpath("//section[@class = 'price-block']");
    private final static By DETAILS_BUTTON = By.xpath("//a[text() = 'פרטי טיסה']");
    private final static By FLIGHT_PRICE = By.xpath("//span[@class = 'amount']");


    // Constructor
    public FlightSearchPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    // Methods
    /**
     * Sets the departure location.
     * @param departure Departure location.
     */
    public void setDeparture(String departure) throws InterruptedException {
        clearText(departureInput);
        enterText(departureInput, departure);
        Thread.sleep(2000);
    }

    /**
     * Sets the destination location.
     * @param destination Destination location.
     */
    public void setDestination(String destination) throws InterruptedException {
        enterText(destinationInput, destination);
        Thread.sleep(2000);
    }

    /**
     * Sets the start and end dates for the flight search.
     * @param startDate Start date map with day and month.
     * @param endDate End date map with day and month.
     */
    public void setDates(Map<String, String> startDate, Map<String, String> endDate) {
        By startDateButton = By.xpath(DAY_BUTTON_CALENDAR.formatted(startDate.get("month"), startDate.get("day")));
        By endDateButton = By.xpath(DAY_BUTTON_CALENDAR.formatted(endDate.get("month"), endDate.get("day")));
        click(dateInput);
        click(startDateButton);
        click(endDateButton);
    }

    /**
     * Clicks on the search button and switches to the results tab.
     */
    public void searchFlights() {
        click(searchButton);
        switchTab(1);
    }

    /**
     * Gets the price of a specific flight.
     * @param flightNum Index of the flight.
     * @return Price of the flight.
     */
    public String getFlightPrice(int flightNum) {
        WebElement flight = getFlightElement(flightNum);
        return flight.findElement(FLIGHT_PRICE).getText();
    }

    /**
     * Selects a flight and switches to the flight details tab.
     * @param flightNum Index of the flight to select.
     */
    public void selectFlight(int flightNum) {
        WebElement flight = getFlightElement(flightNum);
        click(flight.findElement(DETAILS_BUTTON));
        switchTab(2);
    }

    /**
     * Gets the flight element based on its index.
     * @param flightNum Index of the flight.
     * @return WebElement representing the flight.
     */
    private WebElement getFlightElement(int flightNum) {
        List<WebElement> flights = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan
                (FLIGHTS_LIST, flightNum));
        return flights.get(flightNum);
    }
}