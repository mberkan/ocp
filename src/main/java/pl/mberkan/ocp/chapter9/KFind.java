package pl.mberkan.ocp.chapter9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class KFind {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get(".");
        Files.find(path, 8,
                (p, a) -> p.toString().endsWith(".java") && a.lastModifiedTime().toMillis() > 100)
                .forEach(System.out::println);
    }
}
