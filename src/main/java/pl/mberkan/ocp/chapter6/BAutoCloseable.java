package pl.mberkan.ocp.chapter6;

/**
 * @author Marek Berkan
 */
public class BAutoCloseable implements AutoCloseable {

    public static void main(String[] args) {
        try (BAutoCloseable autoCloseable = new BAutoCloseable()) {
            System.out.println(autoCloseable);
        }
    }

    @Override
    public void close() { // throws Exception { // <-- it doesn't compile!
        System.out.println("Close!");
    }
}
