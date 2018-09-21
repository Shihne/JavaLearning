/*
Взять текстовый файл, желательно большой на русском. Прочитать из него все слова, каждое слово привести к нижнему регистру и сохранить в множестве HashSet. Вывести все слова.
Повторите аналогичные действия для TreeSet, LinkedHashSet. Т.е. Ваша программа должна читать текстовый файл три раза. Убедитесь, что вы не дублируете код, и не скопировали
программу три раза для каждого из видов множества.
 */

import java.io.File;
import java.util.*;

public class ToLowerCase {
    public static void main(String[] args) {
        File text = new File("P:/Java/Project/Collections.txt");

        Set<String> hash = new HashSet<>();
        readAndSave(text, hash);
        System.out.println(hash);

        Set<String> tree = new TreeSet<>();
        readAndSave(text, tree);
        System.out.println(tree);

        Set<String> link = new LinkedHashSet<>();
        readAndSave(text, link);
        System.out.println(link);
    }

    private static void readAndSave(File text, Set<String> set) {
        try (Scanner in = new Scanner(text, "UTF-8").useDelimiter("\\p{Punct}*\\s+|\\p{Punct}")) {
            while (in.hasNext())
                set.add(in.next().toLowerCase());
        } catch (Exception e) {
            System.out.println("Ошибка чтения");
        }
    }
}
