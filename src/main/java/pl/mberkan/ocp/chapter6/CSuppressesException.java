package pl.mberkan.ocp.chapter6;

import java.util.Arrays;

/**
 * When both method and close throws exception the first one is main exception (e) but close exception is suppressed
 * (one of e.getSuppressed()), suppressed means "stłumić" in polish.
 *
 * @author Marek Berkan
 */
public class CSuppressesException implements AutoCloseable {

    int number;

    public CSuppressesException(int number) {
        this.number = number;
    }

    public static void main(String[] args) {
        try (CSuppressesException suppressesException1 = new CSuppressesException(1);
             CSuppressesException suppressesException2 = new CSuppressesException(2)) { // resources are closed in reverse order than created
            System.out.println("Inside try");
            throw new IllegalStateException("Method exception");
        } catch (IllegalStateException e) {
            System.out.println("Inside catch, e: " + e.getMessage());
            Arrays.stream(e.getSuppressed())
                    .forEach(s -> System.out.println("Suppressed: " + s.getMessage()));
        }
    }

    @Override
    public void close() {
        throw new IllegalStateException("Close exception from " + number);
    }
}
