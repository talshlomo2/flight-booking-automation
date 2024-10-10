# Flight Booking Automation Testing

## Overview

This project is an automated testing framework written in **Java** for the flight booking process on the Issta website.
The framework utilizes **Selenium WebDriver** and **TestNG** to perform end-to-end tests for searching, selecting, and checking out flights.

## Technologies Used
- **Java**: JDK 17
- **Maven**: For dependency management and build automation
- **IntelliJ IDEA**: Integrated Development Environment (IDE) for coding and running tests
- **TestNG**: For test configuration and execution
- **Selenium WebDriver**: For browser automation
- **WebDriverManager**: To manage browser driver binaries

## Installation
1. **Ensure Java, Maven, and IntelliJ IDEA are Installed**:
   - Verify Java (JDK 17) is installed:
     ```bash
     java -version
     ```
   - Verify Maven is installed:
     ```bash
     mvn -v
     ```
   - Ensure IntelliJ IDEA is installed and up-to-date.

2. **Clone the Repository**:
   ```bash
   git clone <repository-url>
   cd <repository-directory>
   ```
3. **Open in IntelliJ IDEA:**
- Launch IntelliJ IDEA.
- Select "Open" and choose the project directory. Ensure Maven dependencies are imported automatically.   


## Project Structure

- **pages/**: Contains Page Object Model classes for different pages in the booking flow. Includes `BasePage.java`, which provides common methods for interacting with web elements.
- **tests/**: Contains TestNG test classes for various test scenarios. Includes `BaseTest.java`, which manages the WebDriver.
- **resources/**: Contains the `TestRunner.xml` file for defining test suites.
- **util/**: Contains the `Dates` class which includes date-related functions.

## Test Configuration

Edit the `TestRunner.xml` file to change test parameters, such as departure and destination locations, as well as date offsets for flight searches and more.

## Running the Tests

1. Open IntelliJ IDEA and load your project.
2. Go to Run > Edit Configurations....
3. Click the + icon and select TestNG Suite.
4. Set the Suite file to point to your TestRunner.xml in the resources directory.
5. Click the green run button to execute the tests.