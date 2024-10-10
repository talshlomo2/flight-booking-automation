package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Map;

public class Dates {

    /**
     * Gets the Hebrew date for a specified number of days in the future.
     * @param daysToAdd Number of days to add to the current date.
     * @return A map containing the day and month in Hebrew.
     */
    public static Map<String, String> getHebrewDate(int daysToAdd) {
        LocalDate futureDate = LocalDate.now().plusDays(daysToAdd);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy",
                new Locale("he", "IL"));
        String date = futureDate.format(formatter);
        return splitDate(date);
    }

    /**
     * Helper function that splits a date string into day and month.
     * @param date The formatted date string.
     * @return A map containing the day and month.
     */
    private static Map<String, String> splitDate(String date) {
        String[] dateParts = date.split(" ");
        String day = dateParts[0];
        String month = dateParts[1] + " " + dateParts[2];
        return Map.of("day", day, "month", month);
    }
}