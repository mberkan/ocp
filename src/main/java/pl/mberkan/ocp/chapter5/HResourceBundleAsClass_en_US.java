package pl.mberkan.ocp.chapter5;

import java.time.LocalDateTime;
import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * We can create programmatically resource bundles as normal class.
 *
 * @author Marek Berkan
 */
public class HResourceBundleAsClass_en_US extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][] {{ "date", LocalDateTime.now() }};
    }

    public static void main(String[] args) {
        ResourceBundle rb = ResourceBundle.getBundle("pl.mberkan.ocp.chapter5.HResourceBundleAsClass", Locale.US);
        System.out.println(rb.getObject("date"));
    }
}
