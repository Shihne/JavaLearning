/*
Дана строка. Посчитать каждый символ, сколько раз он встретился. Например, строка “banana” должна выдать массив Map<Character, Integer>:

     'b' -> 1
     'a' -> 3
     'n' -> 2
 */
import java.util.*;

public class FindCharacters {
    public static void main(String[] args) {
        String s = "banana";
        Map<Character, Integer> m = countCharacters(s);
        m.forEach((key, value) -> System.out.println(key + " -> " + value));

        Map<Character, List<Integer>> m1 = getCharactersIndex(s);
        m1.forEach((key, value) -> System.out.println(key + " -> " + value));
    }

    private static Map<Character, Integer> countCharacters(String word) {
        Map<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            Integer freq = m.get(letter);
            //noinspection Java8MapApi
            if (freq == null)
                m.put(letter, 1);
            else
                m.put(letter, freq + 1);
        }
        return m;
    }

    private static Map<Character, List<Integer>> getCharactersIndex(String word) {
        Map<Character, List<Integer>> m = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            List<Integer> l = new ArrayList<>();
            char letter = word.charAt(i);
            List<Integer> list = m.get(letter);
            if (list != null)
                l = list;
            l.add(i);
            m.put(letter, l);
        }
        return m;
    }
}
