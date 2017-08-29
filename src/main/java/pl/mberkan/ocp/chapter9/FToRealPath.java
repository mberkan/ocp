package pl.mberkan.ocp.chapter9;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static pl.mberkan.ocp.Utils.printSeparator;

/**
 * Check if file exists.
 *
 * Example before run:
 * - touch /tmp/realfile.txt
 * - ln -s /tmp/realfile.txt /tmp/sybolic_link.txt
 */
public class FToRealPath {
    public static void main(String[] args) {
        printRealPath(Paths.get("/tmp/sybolic_link.txt"));
        printSeparator();

        printRealPath(Paths.get("."));
        printSeparator();
    }

    private static void printRealPath(Path path) {
        try {
            System.out.println("Real path: " + path.toRealPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
