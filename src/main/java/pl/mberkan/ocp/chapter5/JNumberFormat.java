package pl.mberkan.ocp.chapter5;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * @author Marek Berkan
 */
public class JNumberFormat {
    public static void main(String[] args) {
        formatNumbers();
        formatCurrency();
        parseNumbers();
        parseCurrency();
    }

    private static void formatNumbers() {
        double attendeesPerYear = 3_200_000.24;
        double attendeesPerMonth = attendeesPerYear / 12;
        NumberFormat numberFormatUs = NumberFormat.getInstance(Locale.US);
        NumberFormat numberFormatFr = NumberFormat.getInstance(Locale.FRANCE);
        NumberFormat numberFormatDe = NumberFormat.getInstance(Locale.GERMANY);
        System.out.println(numberFormatUs.format(attendeesPerMonth));
        System.out.println(numberFormatFr.format(attendeesPerMonth));
        System.out.println(numberFormatDe.format(attendeesPerMonth));
    }

    private static void formatCurrency() {
        double price = 10.4;
        NumberFormat currencyFormatUs = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat currencyFormatFr = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        NumberFormat currencyFormatDe = NumberFormat.getCurrencyInstance(Locale.GERMANY);
        System.out.println(currencyFormatUs.format(price));
        System.out.println(currencyFormatFr.format(price));
        System.out.println(currencyFormatDe.format(price));
    }

    private static void parseNumbers() {
        String value = "266666.687";
        System.out.println("Parse number: " + value);
        NumberFormat numberFormatUs = NumberFormat.getInstance(Locale.US);
        NumberFormat numberFormatFr = NumberFormat.getInstance(Locale.FRANCE);
        NumberFormat numberFormatDe = NumberFormat.getInstance(Locale.GERMANY);
        try {
            System.out.println(numberFormatUs.parse(value));
            System.out.println(numberFormatFr.parse(value));
            System.out.println(numberFormatDe.parse(value));
        } catch (ParseException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void parseCurrency() {
        String value = "$266,666.68";
        System.out.println("Parse currency: " + value);
        NumberFormat currencyFormatUs = NumberFormat.getInstance(Locale.US);
        NumberFormat currencyFormatFr = NumberFormat.getInstance(Locale.FRANCE);
        NumberFormat currencyFormatDe = NumberFormat.getInstance(Locale.GERMANY);
        try {
            System.out.println(currencyFormatUs.parse(value));
            System.out.println(currencyFormatFr.parse(value));
            System.out.println(currencyFormatDe.parse(value));
        } catch (ParseException e) {
            System.err.println(e.getMessage());
        }
    }
}
