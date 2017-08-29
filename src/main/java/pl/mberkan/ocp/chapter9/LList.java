package pl.mberkan.ocp.chapter9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LList {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get(".");
        Files.list(path)
                .filter(p -> !Files.isDirectory(p))
                .map(p -> p.toAbsolutePath())
                .forEach(System.out::println);
    }
}
