package pl.mberkan.ocp.chapter9;

import java.nio.file.Path;
import java.nio.file.Paths;

import static pl.mberkan.ocp.Utils.printSeparator;

/**
 * Path methods
 */
public class BPathMethods {
    public static void main(String[] args) {
        nameCount(Paths.get("/home/mberkan/projects/ocp/build.gradle"));
        printSeparator();

        nameCount(Paths.get("build.gradle"));
        printSeparator();

        printPathInformation(Paths.get("/home/mberkan/projects/ocp/build.gradle"));
        printSeparator();
        printPathInformation(Paths.get("build.gradle"));
        printSeparator();

        isAbsolute(Paths.get("/home/mberkan/projects/ocp/build.gradle"));
        printSeparator();
        isAbsolute(Paths.get("build.gradle"));
        printSeparator();

        printSubpath(Paths.get("/home/mberkan/projects/ocp/build.gradle"), 0, 3);
        printSubpath(Paths.get("/home/mberkan/projects/ocp/build.gradle"), 1, 3);
        printSubpath(Paths.get("/home/mberkan/projects/ocp/build.gradle"), 1, 2);

        // -> IllegalArgumentException, 6 is to many
        // printSubpath(Paths.get("/home/mberkan/projects/ocp/build.gradle"), 1, 6);
        // -> IllegalArgumentException, 1 to 1 create empty path
        // printSubpath(Paths.get("/home/mberkan/projects/ocp/build.gradle"), 1, 1);
        printSeparator();
    }

    private static void nameCount(Path path) {

        System.out.println("Path: " + path);

        for (int i = 0; i < path.getNameCount(); i++) {
            System.out.println(" element " + i + " is: " + path.getName(i));
        }
    }


    private static void printPathInformation(Path path) {
        System.out.println("Filename: " + path.getFileName());
        System.out.println("Root: " + path.getRoot());

        Path currentPath = path;
        while ((currentPath = currentPath.getParent()) != null) {
            System.out.println("   current path: " + currentPath);
        }
    }

    private static void isAbsolute(Path path) {
        System.out.println("Path " + path + " is absolute: " + path.isAbsolute());
        System.out.println("Path " + path + " to absolute: " + path.toAbsolutePath());
    }


    private static void printSubpath(Path path, int from, int to) {
        System.out.println("Subpath from " + from + " to " + to + " of path '" + path + "' is: " + path.subpath(from, to));
    }
}
