/*
Частотный словарь слов из файла. Т.е. нужно прочитать слова из файла и посчитать, сколько раз они встретились. Приводите слова к нижнему регистру перед подсчетом. Желательно использовать большой текст на русском, например, возьмите его на http://lib.ru. Используйте Scanner.useDelimiter(), чтобы указать сканеру, какие символы считать разделителями слов.

Сначала используйте HashMap
Потом исправьте программу так, чтобы она использовала все три вида массивов: HashMap, TreeMap, LinkedHashMap. Соответственно, выведите ответ три раза. Не дублируйте код.
Выведите слова в порядке уменьшения частот. Вам потребуется отсортировать список List<Map.Entry<String, Integer»
 */

import java.io.File;
import java.util.*;

public class FrequencyDictionary {
    public static void main(String[] args) {
        File text = new File("P:/Java/Project/Collections.txt");
        Map<String, Integer> hash = new HashMap<>();
        countWords(text, hash);
        hash.forEach((key, value) -> System.out.print(key + " -> " + value + " "));
        System.out.println();

        Map<String, Integer> tree = new TreeMap<>();
        countWords(text, tree);
        tree.forEach((key, value) -> System.out.print(key + " -> " + value + " "));
        System.out.println();

        Map<String, Integer> link = new LinkedHashMap<>();
        countWords(text, link);
        link.forEach((key, value) -> System.out.print(key + " -> " + value + " "));
        System.out.println();

        List<Map.Entry<String, Integer>> l = new ArrayList<>();
        l.addAll(hash.entrySet());
        l.sort((a, b) -> a.getValue() - b.getValue());
        for (Map.Entry<String, Integer> e : l)
            System.out.print(e.getKey() + " -> " + e.getValue() + " ");

    }

    private static void countWords(File text, Map<String, Integer> m) {
        try (Scanner in = new Scanner(text, "UTF-8").useDelimiter("\\p{Punct}*\\s+|\\p{Punct}")) {
            while (in.hasNext()) {
                String word = in.next().toLowerCase();
                Integer freq = m.get(word);
                if (freq == null)
                    m.put(word, 1);
                else
                    m.put(word, freq + 1);
            }
        } catch (Exception e) {
            System.out.println("Ошибка чтения");
        }
    }
}
