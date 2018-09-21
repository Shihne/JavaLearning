import java.util.ArrayList;
import java.util.List;

/* Создать список List<String> из чисел от 1 до 100. Здесь и везде реализуйте функцию, которая решает задачу.
   В main методе вызовите ее для проверки.
*/

public class CreateHundred {
    public static void main(String[] args) {
        List<String> l1 = createHundred();

        test1(l1, 5, "6");
        test1(l1, 75, "76");
        test1(l1, 97, "98");
        test2(l1, 21, 34, "[22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34]");
        test2(l1, 63, 77, "[64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77]");
        test2(l1, 27, 32, "[28, 29, 30, 31, 32]");
    }

    public static List<String> createHundred() {
        List<String> l1 = new ArrayList<>();
        for (int i = 0; i < 100; i++)
            l1.add(i, "" + (i + 1));
        return l1;
    }

    public static void test1(List<String> l1, int value, String correctAnswer) {
        System.out.println("Looking for " + value + " in l1");
        if (l1.get(value).equals(correctAnswer))
            System.out.println("ok");
        else
            System.out.println("Got " + l1.get(value) + " instead of " + correctAnswer);
    }

    public static void test2(List<String> l1, int begin, int end, String correctAnswer) {
        System.out.println("Looking for " + begin + "-" + end + " in l1");
        if (l1.subList(begin, end).toString().equals(correctAnswer))
            System.out.println("ok");
        else
            System.out.println("Got " + l1.subList(begin, end) + " instead of " + correctAnswer);
    }
}
