package pl.mberkan.ocp.chapter9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static pl.mberkan.ocp.Utils.printSeparator;

/**
 * Methods of Files class.
 *
 * Another intuitive methods:
 * - copy(Path, Path, ...)
 * - copy(InputStream, Path, ...)
 * - copy(Path, OutputStream)
 * - move(Path, Path, ...)
 * - delete(Path)
 * - deleteIfExists(Path)
 * - isDirectory(Path)
 * - isRegularFile(Path)
 * - isSymbolicLink(Path)
 * - isHidden(Path)
 * - isReadable(Path)
 * - isExecutable(Path)
 * - size(Path)
 * - getLastModifiedTime(Path)
 * - setLastModifiedTime(Path, FileTime)
 */
public class GFiles {
    public static void main(String[] args) {
        Path path1 = Paths.get("build.gradle");
        Path path2 = Paths.get("/home/mberkan/projects/ocp/build.gradle");

        pathExists(path1);
        printSeparator();

        isSameFile(path1, path2);
        printSeparator();
    }

    private static void pathExists(Path path) {
        System.out.println("File exists: " + Files.exists(path));
    }

    private static void isSameFile(Path path1, Path path2) {
        try {
            System.out.println("Is the same file: " + Files.isSameFile(path1, path2));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
