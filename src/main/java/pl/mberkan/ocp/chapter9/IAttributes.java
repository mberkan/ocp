package pl.mberkan.ocp.chapter9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserPrincipal;

public class IAttributes {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/home/mberkan/projects/ocp/build.gradle");
        BasicFileAttributes data = Files.readAttributes(path, BasicFileAttributes.class);
        System.out.println("Is directory: " + data.isDirectory());
        System.out.println("Is regular file: " + data.isRegularFile());
        System.out.println("Is symbolic link: " + data.isSymbolicLink());
        System.out.println("Is other: " + data.isOther());
        System.out.println("Size: " + data.size());
        System.out.println("Creation time: " + data.creationTime());
        System.out.println("Last modified time: " + data.lastModifiedTime());
        System.out.println("Last access time: " + data.lastAccessTime());
        System.out.println("File key: " + data.fileKey());

        BasicFileAttributeView view = Files.getFileAttributeView(path, BasicFileAttributeView.class);
        FileTime fileTime = FileTime.fromMillis(0);
        view.setTimes(fileTime, null, null);

        System.out.println("Last modified time: " + Files.getLastModifiedTime(path));
    }
}
