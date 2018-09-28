import java.io.File;
import java.io.PrintStream;

public class ReadingAndWritingFiles {
    public static void main(String[] args) {
        String text = "Заведите в программе переменную text и присвойте ей какой-нибудь русский текст длиной в одно предложение.";

        writeText(new File("Task4/text_utf8.txt"), "utf-8", text);
        writeText(new File("Task4/text_win1251.txt"), "windows-1251", text);
        writeText(new File("Task4/text_koi8r.txt"), "koi8-r", text);


    }

    private static void writeText(File target, String coding, String text) {
        try (PrintStream out = new PrintStream(target, coding)) {
            out.println(text);
        } catch (Exception e) {
            System.out.println("Запись не удалась");
        }
    }
}
