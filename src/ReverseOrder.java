/*
  Дан список, верните новый список, в котором все элементы идут в обратном порядке.
  Сделайте две версии задачи: чистую функцию и функцию, которая меняет заданный список.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseOrder {
    public static void main(String[] args) {
        List<String> l = new ArrayList<>(Arrays.asList("60", "64", "95", "18", "91", "47", "14"));
        List<String> l1 = clearFunction(l);
        System.out.println(l1);
        System.out.println(l);
        voidFunction(l);
        System.out.println(l);
    }

    public static  List<String> clearFunction(List<String> l) {
        List<String> l1 = new ArrayList<>(l);
        Collections.sort(l1);
        Collections.reverse(l1);
        return l1;
    }

    public static void voidFunction(List<String> list) {
        Collections.sort(list);
        Collections.reverse(list);
    }
}
