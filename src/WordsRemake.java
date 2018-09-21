import objects.transformers.DictionaryBackTransformer;
import objects.transformers.DictionaryTransformer;
import objects.transformers.WordTransformer;

import java.io.File;
import java.io.PrintStream;
import java.util.*;

public class WordsRemake {
    public static void main(String[] args) {
        String text = "text.txt";
        reWrite(text, "p1.txt", word -> word.toUpperCase());
        reWrite(text, "p4.txt", word -> word.length() + "");
        reWrite(text, "p5.txt", new DictionaryTransformer("words_alpha.txt"));
        reWrite("p5.txt", "text_back.txt", new DictionaryBackTransformer("words_alpha.txt"));
    }

    private static void reWrite(String s1, String s2, WordTransformer wt) {
        File f1 = new File(s1);
        File f2 = new File(s2);
        List<String> list = new ArrayList<>();
        try(Scanner in = new Scanner(f1, "UTF-8").useDelimiter("[^a-zA-Z0-9]+")) {
            while (in.hasNext())
                list.add(wt.transform(in.next()));
        } catch (Exception e) {
            System.out.println("Ошибка чтения");
        }
        try(PrintStream out = new PrintStream(f2, "UTF-8")) {
            for (String word : list)
                out.println(word);
        } catch (Exception e) {
            System.out.println("Ошибка записи");
        }
    }
}
