/**
 * Created by st064329 on 16.02.2018.
 */
public class BinarySearcher {
    public static void main(String[] args) {
        int[] a = {1, 4, 5, 10, 20, 100};
        test(a, 5, 2);
        test(a, 1, 0);
        test(a, 100, 5);
        test(a, 42, -1);
        test(a, 120, -1);
        test(a, 0, -1);

        int[] b = {1, 4, 6, 65, 100};
        test(b, 0, -1);
        test(b, 1, 0);
        test(b, 2, -1);
        test(b, 4, 1);
        test(b, 5, -1);
        test(b, 6, 2);
        test(b, 10, -1);
        test(b, 65, 3);
        test(b, 70, -1);
        test(b, 100, 4);
        test(b, 200, -1);

        int[] c = {1, 4, 6, 65, 100, 110};
        test(c, 0, -1);
        test(c, 1, 0);
        test(c, 2, -1);
        test(c, 4, 1);
        test(c, 5, -1);
        test(c, 6, 2);
        test(c, 10, -1);
        test(c, 65, 3);
        test(c, 70, -1);
        test(c, 100, 4);
        test(c, 105, -1);
        test(c, 110, 5);
        test(c, 200, -1);

        test(new int[]{}, 42, -1);
        test(new int[]{42}, 0, -1);
        test(new int[]{42}, 42, 0);
        test(new int[]{42}, 100, -1);

        test(new int[]{10, 20}, 0, -1);
        test(new int[]{10, 20}, 10, 0);
        test(new int[]{10, 20}, 15, -1);
        test(new int[]{10, 20}, 20, 1);
        test(new int[]{10, 20}, 25, -1);
    }

    //найти в массиве 'a' значение 'value', вернуть индекс или -1,
    //если не найдено
    public static int binarySearch(int[] a, int value) {
        //ищем значение от индекса l до индекса r
        // -----------------------
        //      l      m      r
        //      --------
        int l = 0;
        int r = a.length;
        while (l < r) {
            int m = (l + r) / 2; //середина диапазона
            if (a[m] == value)
                return m;
            else if (a[m] > value)
                r = m;
            else
                l = m + 1;
        }
        return -1;
    }

    private static void test(int[] a, int value, int correctAnswer) {
        // Looking for value in array
        int actualAnswer = binarySearch(a, value);
        if (actualAnswer == correctAnswer)
            System.out.println("ok");
        else
            System.out.println("Got " + actualAnswer + " instead of " + correctAnswer);
    }
}
