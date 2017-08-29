package pl.mberkan.ocp.chapter9;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JWalking {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get(".");
        Files.walk(path, 7, FileVisitOption.FOLLOW_LINKS)
                .filter(p -> p.toString().endsWith(".java"))
                .forEach(System.out::println);
    }
}
