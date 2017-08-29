package pl.mberkan.ocp.chapter9;

import java.nio.file.Path;
import java.nio.file.Paths;

import static pl.mberkan.ocp.Utils.printSeparator;

/**
 * Path.resolve "merges" two paths.
 *
 * If argument is absolute then is returned and source object is ignored.
 */
public class DResolve {
    public static void main(String[] args) {
        printResolved(Paths.get("src"), Paths.get("test2.txt"));
        printSeparator();

        printResolved(Paths.get("/home/mberkan/projects/ocp/build.gradle"),
                Paths.get("/home/mberkan/projects/ocp/src/main/java/pl/mberkan/ocp/chapter9/nio2.png"));
        printSeparator();
    }

    private static void printResolved(Path path1, Path path2) {
        System.out.println("Path " + path1 + " to " + path2 + " resolved is: " + path1.resolve(path2));
    }
}
