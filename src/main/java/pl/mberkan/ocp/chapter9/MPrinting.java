package pl.mberkan.ocp.chapter9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class MPrinting {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("build.gradle");
        System.out.println(Files.lines(path)
                .filter(l -> l.startsWith("apply plugin: "))
                .map(l -> l.replaceAll("apply plugin: ", ""))
                .collect(Collectors.toList()));
    }
}
