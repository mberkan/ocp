package pl.mberkan.ocp.chapter9;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * "Normalize" removes rendudant ".." and ".", doesn;t work with real filesystem.
 */
public class ENormalize {
    public static void main(String[] args) {
        Path path = Paths.get("/tmp/test1/../test2/./file.txt");
        System.out.println("Path original: " + path);
        System.out.println("Path normalized: " + path.normalize());
    }
}
