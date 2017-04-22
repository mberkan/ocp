package pl.mberkan.ocp.chapter5;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author Marek Berkan
 */
public class ACreatingDatesAndTimes {

    public static void main(String[] args) {
        printVariousDates();
        compareMonths();
        createDateAndTime();
        throwDateException();
        manipulate();
    }

    private static void printVariousDates() {
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());
        System.out.println(ZonedDateTime.now());
    }

    private static void compareMonths() {
        Month month = Month.APRIL;
        // boolean b1 = month == 1; // doesn't compile
        boolean b2 = month == Month.MAY;
    }

    private static void createDateAndTime() {
        LocalDate date1 = LocalDate.of(2000, 04, 18);
        LocalTime time1 = LocalTime.of(20, 50, 33, 100);

        LocalDateTime dateTime1 = LocalDateTime.of(date1, time1);

        System.out.println(dateTime1);

        ZoneId zoneId = ZoneId.of("Europe/Warsaw");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime1, zoneId);

        System.out.println(zonedDateTime);
    }

    private static void throwDateException() {
        try {
            LocalDate.of(2017, 02, 30);
        } catch (DateTimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void manipulate() {
        LocalDate localDate = LocalDate.of(2015, Month.FEBRUARY, 20);
        LocalTime localTime = LocalTime.of(5, 15);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        System.out.println(localDateTime);

        localDateTime = localDateTime.plusDays(9);
        System.out.println(localDateTime);

    }


}
