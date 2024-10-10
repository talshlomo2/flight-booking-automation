package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.Assert;
import pages.*;

import static util.Dates.getHebrewDate;

public class TestFlightBooking extends BaseTest {

    /**
     * TestFlightBooking class contains test cases for flight booking functionality.
     * It extends BaseTest to inherit WebDriver management.
     */

    // Pages
    private NavigationMenu navigationMenu;
    private FlightSearchPage flightSearchPage;
    private FlightDetailsPage flightDetailsPage;
    private CheckoutPage checkoutPage;

    // Variables
    private String flightPrice;

    /**
     * Initializes page objects before any tests are run.
     */
    @BeforeClass
    public void setupPages() {
        this.navigationMenu = new NavigationMenu(driver, wait);
        this.flightSearchPage = new FlightSearchPage(driver, wait);
        this.flightDetailsPage = new FlightDetailsPage(driver, wait);
        this.checkoutPage = new CheckoutPage(driver, wait);
    }

    /**
     * Tests searching for flights based on specified parameters.
     * @param departure The departure location.
     * @param destination The destination location.
     * @param startDateOffset Days offset for start date.
     * @param endDateOffset Days offset for end date.
     */
    @Test
    @Parameters({"departure", "destination", "startDateOffset", "endDateOffset"})
    public void testSearchForFlights(String departure, String destination, int startDateOffset,
                                     int endDateOffset) throws InterruptedException {
        navigationMenu.openFlightsTab();
        flightSearchPage.setDeparture(departure);
        flightSearchPage.setDestination(destination);
        flightSearchPage.setDates(getHebrewDate(startDateOffset), getHebrewDate(endDateOffset));
        flightSearchPage.searchFlights();
    }

    /**
     * Tests flight selection after searching for flights.
     * @param flightNum The index of the flight to select.
     */
    @Test(dependsOnMethods = {"testSearchForFlights"})
    @Parameters("flightNum")
    public void testFlightSelection(int flightNum) {
        flightPrice = flightSearchPage.getFlightPrice(flightNum);
        flightSearchPage.selectFlight(flightNum);
        flightDetailsPage.clickContinue();
    }

    /**
     * Verifies that the checkout page is displayed and that the price is correct.
     */
    @Test(dependsOnMethods = {"testFlightSelection"})
    public void testFlightCheckout() {
        String checkoutPrice = checkoutPage.getCheckoutPrice();
        Assert.assertEquals(checkoutPrice, flightPrice,
                "The checkout total sum does not equal the price in the flight details page");
    }
}