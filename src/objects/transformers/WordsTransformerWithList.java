package objects.transformers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class WordsTransformerWithList implements WordTransformer {
    protected List<String> words;

    public WordsTransformerWithList(String s) {
        File f = new File(s);
        List<String> l = new ArrayList<>();
        try (Scanner in = new Scanner(f, "UTF-8").useDelimiter("[^a-zA-Z0-9]+")) {
            while (in.hasNext())
                l.add(in.next());
        } catch (Exception e) {
            System.out.println("Ошибка чтения");
        }
        this.words = l;
    }
}
