/*
Дан файл. Посчитайте среднюю длину слов в этом файле. А еще максимальные и минимальные длины слов. Используйте подходящий Collector.
Найдите самое длинное слово в файле. Получится сделать это за один проход по потоку?
 */

import java.io.File;
import java.util.*;
import java.util.stream.Stream;

public class AverageLength {
    public static void main(String[] args) {
        File f = new File("P:/Java/Project/Collections.txt");

        Stream<String> s = wordsStream(f);
        //double average = s.mapToInt(word -> word.length()).average().getAsDouble();
        double average = s.mapToInt(String::length).average().orElse(0);
        System.out.println(average);

        Stream<String> s2 = wordsStream(f);
        int max = s2.mapToInt(String::length).max().orElse(0);
        System.out.println(max);
        Stream<String> s3 = wordsStream(f);
        int min = s3.mapToInt(String::length).min().orElse(0);
        System.out.println(min);

        Stream<String> s4 = wordsStream(f);
        String longest = s4.min((b, a) -> b.length() - a.length()).orElse("???");
        System.out.println(longest);
    }

    public static Stream<String> wordsStream(File f) {
        try (Scanner in = new Scanner(f, "UTF-8").useDelimiter("\\p{Punct}*\\s+|\\p{Punct}")) {
            Set<String> l = new HashSet<>();
            while (in.hasNext())
                l.add(in.next());
            return l.stream();
        } catch (Exception e) {
            System.out.println("Failed to read file " + f);
            return Stream.of();
        }
    }
}
