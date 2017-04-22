package pl.mberkan.ocp.chapter5;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.UnsupportedTemporalTypeException;

/**
 * @author Marek Berkan
 */
public class CDuration {
    public static void main(String[] args) {
        printDuration();
        calculateDifference();
        doNotPlusDurationWithDate();
    }

    private static void printDuration() {
        Duration duration = Duration.ofMinutes(90);
        System.out.println(duration);

        LocalDateTime localDateTime = LocalDateTime.of(2017, 04, 18, 21, 25, 14);
        System.out.println(localDateTime);

        localDateTime = localDateTime.plus(duration);
        System.out.println(localDateTime);
    }

    private static void calculateDifference() {
        LocalDateTime localDateTime1 = LocalDateTime.of(2017, 04, 18, 21, 25, 14);
        LocalDateTime localDateTime2 = LocalDateTime.of(2017, 04, 11, 10, 25, 14);
        long hours = ChronoUnit.HOURS.between(localDateTime1, localDateTime2);
        System.out.println("Hours between: " + hours);

        long days = ChronoUnit.DAYS.between(localDateTime1, localDateTime2);
        System.out.println("Days between: " + days);

    }

    private static void doNotPlusDurationWithDate() {

        LocalDate localDate = LocalDate.of(2017, 04, 18);
        Duration duration = Duration.ofMinutes(90);
        try {
            localDate = localDate.plus(duration);
            System.out.println(localDate);
        } catch (UnsupportedTemporalTypeException e) {
            System.out.println(e);
        }

    }
}
