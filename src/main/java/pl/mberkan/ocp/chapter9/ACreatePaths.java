package pl.mberkan.ocp.chapter9;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

import static pl.mberkan.ocp.Utils.printSeparator;

/**
 * Base methods to create Path object.
 */
public class ACreatePaths {

    public static void main(String[] args) throws URISyntaxException {
        createPaths();
        printSeparator();

        createPathFromTokens();
        printSeparator();

        createPathWithUri();
        printSeparator();

        createPathsWithFileSystem();
        printSeparator();

        pathToFileConversion();
        printSeparator();

        fileToPathConversion();
        printSeparator();
    }

    private static void createPaths() {
        Path path1 = Paths.get("build.gradle");
        Path path2 = Paths.get("/home/mberkan/projects/ocp/build.gradle");

        System.out.println("path1: " + path1);
        System.out.println("path2: " + path2);
    }

    private static void createPathFromTokens() {
        Path path = Paths.get("/", "home", "mberkan", "projects", "ocp", "build.gradle");
        System.out.println("path: " + path);
    }

    private static void createPathWithUri() throws URISyntaxException {
        Path path = Paths.get(new URI("file:///home/mberkan/projects/ocp/build.gradle"));
        System.out.println("path: " + path);
    }

    private static void createPathsWithFileSystem() {
        Path path1 = FileSystems.getDefault().getPath("build.gradle");
        Path path2 = FileSystems.getDefault().getPath("/home/mberkan/projects/ocp/build.gradle");

        System.out.println("path1: " + path1);
        System.out.println("path2: " + path2);
    }

    private static void pathToFileConversion() {
        Path path = Paths.get("build.gradle");
        File file = path.toFile();
        System.out.println("file from path: " + file);
    }

    private static void fileToPathConversion() {
        File file = new File("build.gradle");
        Path path = file.toPath();
        System.out.println("path from file: " + path);
    }
}
