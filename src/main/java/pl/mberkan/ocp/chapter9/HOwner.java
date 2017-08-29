package pl.mberkan.ocp.chapter9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.UserPrincipal;

public class HOwner {
    public static void main(String[] args) {
        try {
            Path path = Paths.get("/home/mberkan/projects/ocp/build.gradle");
            System.out.println("Owner: " + Files.getOwner(path).getName());

            UserPrincipal owner = path.getFileSystem().getUserPrincipalLookupService().lookupPrincipalByName("mberkan");
            Files.setOwner(path, owner);

            System.out.println("Owner: " + Files.getOwner(path).getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
