package pl.mberkan.ocp.chapter5;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

/**
 * @author Marek Berkan
 */
public class KDateTimeFormat {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2017, 04, 19);
        LocalTime time = LocalTime.of(19, 50, 20);
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        Locale locale = new Locale("en", "US");

        printIso(date, time, dateTime);
        printShort(date, time, dateTime, locale);
        printMedium(date, time, dateTime, locale);
        printCustom(date, time, dateTime, locale);

    }

    private static void printMedium(LocalDate date, LocalTime time, LocalDateTime dateTime, Locale locale) {
        System.out.println("Medium");
        System.out.println(date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(locale)));
        System.out.println(dateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(locale)));
        System.out.println(time.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM).withLocale(locale)));
    }

    private static void printShort(LocalDate date, LocalTime time, LocalDateTime dateTime, Locale locale) {
        System.out.println("Short");
        System.out.println(date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(locale)));
        System.out.println(dateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(locale)));
        System.out.println(time.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).withLocale(locale)));
    }

    private static void printIso(LocalDate date, LocalTime time, LocalDateTime dateTime) {
        System.out.println("ISO");
        System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println(time.format(DateTimeFormatter.ISO_LOCAL_TIME));
        System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    }

    private static void printCustom(LocalDate date, LocalTime time, LocalDateTime dateTime, Locale locale) {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("MMMM dd, yyyy, hh:mm");
        System.out.println(dateTime.format(f.withLocale(locale)));
    }
}
