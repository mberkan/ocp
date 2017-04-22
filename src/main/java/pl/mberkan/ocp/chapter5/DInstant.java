package pl.mberkan.ocp.chapter5;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.UnsupportedTemporalTypeException;

/**
 * The Instant class represents a specific time in the GMT! time zone.
 *
 * @author Marek Berkan
 */
public class DInstant {

    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2000, 04, 18);
        LocalTime time1 = LocalTime.of(20, 50, 33, 100);

        LocalDateTime dateTime1 = LocalDateTime.of(date1, time1);

        System.out.println(dateTime1);

        ZoneId zoneId = ZoneId.of("Europe/Warsaw");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime1, zoneId);

        System.out.println(zonedDateTime);

        Instant instant = zonedDateTime.toInstant();
        System.out.println(instant);

        instant = instant.plusSeconds(10);
        System.out.println(instant);

        try {
            instant = instant.plus(10, ChronoUnit.WEEKS);
            System.out.println(instant);
        } catch (UnsupportedTemporalTypeException e) {
            System.out.println(e);
        }
    }
}
