package pl.mberkan.ocp.chapter5;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.UnsupportedTemporalTypeException;

/**
 * @author Marek Berkan
 */
public class BPeriods {
    public static void main(String[] args) {
        printPeriod();
        usePeriod();
        doNotPlusPeriodWithTime();
    }

    private static void printPeriod() {
        System.out.println(Period.of(15, 2, 3));
        System.out.println(Period.of(0, 2, 3));
        System.out.println(Period.of(3, 0, 3));
        System.out.println(Period.ofMonths(1));
    }

    private static void usePeriod() {
        LocalDate start = LocalDate.of(2015, Month.JANUARY, 1);
        LocalDate end = LocalDate.of(2015, Month.MARCH, 30);
        Period period = Period.ofMonths(1);
        performAnimalEnrichnment(start, end, period);
    }

    private static void performAnimalEnrichnment(LocalDate start, LocalDate end, Period period) {
        LocalDate upTo = start;
        while (upTo.isBefore(end)) {
            System.out.println("Give new toy: " + upTo);
            upTo = upTo.plus(period);
        }
    }

    private static void doNotPlusPeriodWithTime() {
        LocalTime time = LocalTime.of(20, 30, 13);
        Period period = Period.ofWeeks(3);
        try {
            time = time.plus(period);
            System.out.println(time);
        } catch (UnsupportedTemporalTypeException e) {
            System.out.println(e);
        }
    }
}
