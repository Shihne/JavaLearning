import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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

        byte[] bytesUTF = readBytes(Paths.get(textWin));
        for (byte b : bytesUTF)
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
}
