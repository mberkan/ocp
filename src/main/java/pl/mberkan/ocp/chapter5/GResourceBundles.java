package pl.mberkan.ocp.chapter5;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * @author Marek Berkan
 */
public class GResourceBundles {
    public static void main(String[] args) {
        Locale localeEnUs = new Locale("en", "US");
        Locale localeFrFr = new Locale("fr", "FR");
        printProperties(localeEnUs);
        printProperties(localeFrFr);
    }

    private static void printProperties(Locale locale) {
        ResourceBundle rb = ResourceBundle.getBundle("pl.mberkan.ocp.chapter5.GResourceBundles_Zoo", locale);
        System.out.println(rb.getString("hello"));
        System.out.println(rb.getString("open"));
        System.out.println(rb.getString("test1")); // "test1:Test 1" - ':' delimiter!
        System.out.println(rb.getString("test2")); // "test2 Test 2" - ' ' delimiter!
        try {
            System.out.println(rb.getString("test3")); // "#test3=Comment" - '#' is comment
        } catch (MissingResourceException e) {
            System.err.println(e.getMessage());
        }
        try {
            System.out.println(rb.getString("test4")); // "!test4=Comment" - '!' is comment too!
        } catch (MissingResourceException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("'" + rb.getString("test5") + "'"); // trailing spaces at the beginning are ignored, at the end not!
        System.out.println(rb.getString("test6")); // lines in file may be split by /
        System.out.println(rb.getString("test7")); // \t and \n are allowed
    }
}
