/*
Сделайте по две версии следующих трех функций: чистую функцию и функцию, которая меняет заданный список.
Дан List<String>, удалите в нем все элементы с четным индексом.
Дан List<String>, удалить в нем все элементы, которые являются четными числами
Дан List<Integer>, удалить в нем все элементы, которые являются четными числами
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EvenElement {
    public static void main(String[] args) {
        List<String> l1 = new ArrayList<>(Arrays.asList("24", "15", "47", "49", "99", "20", "30", "11"));
        List<String> l2 = new ArrayList<>(Arrays.asList("48", "57", "32", "42", "97", "33", "50"));
        List<Integer> l3 = new ArrayList<>(Arrays.asList(42, 99, 68, 24, 73, 62, 77, 55, 42));

        List<String> nl1 = clearFunction1(l1);
        System.out.println(nl1);
        System.out.println(l1);
        voidFunction1(l1);
        System.out.println(l1);

        List<String> nl2 = clearFunction2(l2);
        System.out.println(nl2);
        System.out.println(l2);
        voidFunction2(l2);
        System.out.println(l2);

        List<Integer> nl3 = clearFunction3(l3);
        System.out.println(nl3);
        System.out.println(l3);
        voidFunction3(l3);
        System.out.println(l3);
    }

    public static List<String> clearFunction1 (List<String> l) {
        List<String> nl = new ArrayList<>();
        for (int i = 1; i < l.size(); i = i + 2)
            nl.add(l.get(i));
        return nl;
    }

    public static void voidFunction1 (List<String> l) {
        int startIndex;
        if ((l.size() - 1) % 2 == 0)
            startIndex = l.size() - 1;
        else
            startIndex = l.size() - 2;

        for (int i = startIndex; i >= 0; i = i - 2)
            l.remove(i);
    }

    public static List<String> clearFunction2(List<String> l) {
        List<String> nl = new ArrayList<>();
        for (String s : l) {
            int x = Integer.parseInt(s);
            if (x % 2 == 1/*s.endsWith("1") || s.endsWith("3") || s.endsWith("5") || s.endsWith("7") || s.endsWith("9")*/)
                nl.add(s);
        }
        return nl;
    }

    public static void voidFunction2(List<String> l) {
        for (int i = l.size() - 1; i >= 0; i--)
            if (l.get(i).endsWith("0") || l.get(i).endsWith("2") || l.get(i).endsWith("4") || l.get(i).endsWith("6") || l.get(i).endsWith("8"))
                l.remove(l.get(i));
    }

    public static List<Integer> clearFunction3(List<Integer> l) {
        List<Integer> nl = new ArrayList<>();
        for (int e : l)
            if (e % 2 != 0)
                nl.add(e);
        return nl;
    }

    public static void voidFunction3(List<Integer> l) {
        for (int i = l.size() - 1; i >= 0; i--)
            if (l.get(i) % 2 == 0)
//                l.remove(l.get(i));
                l.remove(i);
    }
}
