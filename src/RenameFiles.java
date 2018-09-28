import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class RenameFiles {
    public static void main(String[] args) {
        List<String> fileNames = Arrays.asList("a.txt", "b.txt", "c.txt");
        int i = 1;
        for (String str : fileNames) {
            renameFile(Paths.get("Task3/" + str), Paths.get("Task3/" + i + " " + str));
            i++;
        }
    }

    private static void renameFile(Path source, Path target) {
        try {
            Files.move(source, target, REPLACE_EXISTING);
        } catch (Exception e) {
            System.out.println("Ошибка переименовывания");
        }
    }
}
