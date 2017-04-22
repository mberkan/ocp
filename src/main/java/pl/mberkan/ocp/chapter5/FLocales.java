package pl.mberkan.ocp.chapter5;

import java.util.Locale;

/**
 * @author Marek Berkan
 */
public class FLocales {
    public static void main(String[] args) {
        printLocale();
        invalidLocaleCodes();
        usingLocaleBuilder();

    }

    private static void printLocale() {
        Locale locale = Locale.getDefault();
        System.out.println(locale);
    }

    private static void invalidLocaleCodes() {
        // invalid ones:
        Locale us = new Locale("US"); // not language
        System.out.println(us);
        Locale enUs = new Locale("enUS"); // without separator
        System.out.println(enUs);
        Locale usEn = new Locale("US_en"); // reverse order
        System.out.println(usEn);
        Locale EN = new Locale("EN"); // upper case
        System.out.println(EN);
    }

    private static void usingLocaleBuilder() {
        Locale locale = new Locale.Builder()
                .setLanguage("en")
                .setRegion("US")
                .build();
        System.out.println(locale);
    }
}
