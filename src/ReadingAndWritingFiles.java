import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class ReadingAndWritingFiles {
    public static void main(String[] args) {
        String text = "Заведите в программе переменную text и присвойте ей какой-нибудь русский текст длиной в одно предложение.";
        //String s = x == 2 ? "два" : "не два";

        String textUtf = "Task4/text_utf8.txt";
        String textWin = "Task4/text_win1251.txt";
        String textKoi = "Task4/text_koi8r.txt";

        writeText(new File(textUtf), "utf-8", text);
        writeText(new File(textWin), "windows-1251", text);
        writeText(new File(textKoi), "koi8-r", text);

        byte[] bytesUTF = readBytes(Paths.get(textUtf));
        byte[] bytesWin = readBytes(Paths.get(textWin));

        /*try {
            Files.write(Paths.get("Task4/text_utf8.bin"), bytesUTF);

        } catch (IOException e) {
            e.printStackTrace();
        }*/
        writeBytes(Paths.get("Task4/text_utf8.bin"), bytesUTF);
        writeBytes(Paths.get("Task4/text_win1251.bin"), bytesWin);
        for (byte b : bytesWin)
            System.out.println((b & 0xFF) + " " + b + " " + Integer.toString(b & 0xFF, 16));
    }

    

    private static void writeText(File target, String coding, String text) {
        try (PrintStream out = new PrintStream(target, coding)) {
            out.println(text);
        } catch (Exception e) {
            System.out.println("Запись не удалась");
        }
    }

    private static byte[] readBytes(Path path) {
        byte[] allBytes = new byte[0];
        try {
            allBytes = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allBytes;
    }

    private static void writeBytes(Path path, byte[] bytes) {
        List<String> list = new ArrayList<>();
        for (byte b : bytes)
            list.add((b & 0xFF) + " " + b + " " + Integer.toString(b & 0xFF, 16));
        try {
            Files.write(path, list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
