import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class RenameFiles {
    public static void main(String[] args) {

        renameFile(Paths.get("Task3/a.txt"), Paths.get("Task3/1 a.txt"));
        renameFile(Paths.get("Task3/b.txt"), Paths.get("Task3/2 b.txt"));

    }

    private static void renameFile(Path source, Path target) {
        try {
            Files.move(source, target, REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
