package pl.mberkan.ocp.chapter5;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Marek Berkan
 */
public class LResourceBundleTest {
    public static void main(String[] args) {
        Locale fr = new Locale("fr");
        Locale.setDefault(new Locale("en", "US"));
        ResourceBundle b = ResourceBundle.getBundle("pl.mberkan.ocp.chapter5.Dolphins", fr);
        System.out.println(b.getString("name"));
        System.out.println(b.getString("age"));
    }
}
