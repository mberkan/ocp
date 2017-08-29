package pl.mberkan.ocp.chapter9;

import java.nio.file.Path;
import java.nio.file.Paths;

import static pl.mberkan.ocp.Utils.printSeparator;

/**
 * Examples of using relativize methods.
 *
 * Works only on relative path or absolute path, not mixed!
 */
public class CRelativize {
    public static void main(String[] args) {
        printRelativized(Paths.get("test1.txt"), Paths.get("test2.txt"));
        printSeparator();

        printRelativized(Paths.get("/home/mberkan/projects/ocp/build.gradle"),
                Paths.get("/home/mberkan/projects/ocp/src/main/java/pl/mberkan/ocp/chapter9/nio2.png"));
        printSeparator();

        // -> throws "IllegalArgumentException: 'other' is different type of Path"
//        printRelativized(Paths.get("build.gradle"),
//                Paths.get("/home/mberkan/projects/ocp/src/main/java/pl/mberkan/ocp/chapter9/nio2.png"));
    }

    private static void printRelativized(Path path1, Path path2) {
        System.out.println("Path " + path1 + " to " + path2 + " relativized is: " + path1.relativize(path2));
        System.out.println("Path " + path2 + " to " + path1 + " relativized is: " + path2.relativize(path1));
    }
}
