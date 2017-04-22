package pl.mberkan.ocp.chapter5;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * One day in March is 23 hours long
 * One day in November is 25 hours long
 *
 * @author Marek Berkan
 */
public class EDaylightSavingsTime {
    public static void main(String[] args) {
        showChangesInMarch();
        showChangesInNovember();
    }

    private static void showChangesInMarch() {
        LocalDate date1 = LocalDate.of(2016, Month.MARCH, 13);
        LocalTime time1 = LocalTime.of(1, 30);
        LocalDateTime dateTime1 = LocalDateTime.of(date1, time1);

        ZoneId zoneId = ZoneId.of("US/Eastern");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime1, zoneId);
        System.out.println(zonedDateTime);

        zonedDateTime = zonedDateTime.plusHours(1);
        System.out.println(zonedDateTime);
    }

    private static void showChangesInNovember() {
        LocalDate date1 = LocalDate.of(2016, Month.NOVEMBER, 6);
        LocalTime time1 = LocalTime.of(1, 30);
        LocalDateTime dateTime1 = LocalDateTime.of(date1, time1);

        ZoneId zoneId = ZoneId.of("US/Eastern");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime1, zoneId);
        System.out.println(zonedDateTime);

        zonedDateTime = zonedDateTime.plusHours(1);
        System.out.println(zonedDateTime);

        zonedDateTime = zonedDateTime.plusHours(1);
        System.out.println(zonedDateTime);
    }
}
