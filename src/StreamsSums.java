/*
Дано n. Посчитайте сумму
    чисел от 1 до n
    квадратов чисел от 1 до n
    кубов чисел от 1 до n
    обратных чисел от 1 до n
 */

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsSums {
    public static void main(String[] args) {
        int n = 5;

        int sum1 = IntStream.rangeClosed(1, n).sum();
        System.out.println(sum1);

        int sum2 = IntStream.rangeClosed(1, n)
                .map(x -> x * x)
                .sum();
        System.out.println(sum2);

        int sum3 = IntStream.iterate(1, x -> x + 1)
                .limit(n)
                .map(x -> x * x * x)
                .sum();
        System.out.println(sum3);

        double sum4 = IntStream.iterate(1, x -> x + 1)
                .limit(n)
                .mapToDouble(x -> Math.pow(x, -1))
                .sum();
        System.out.println(sum4);

        List<Integer> l = new ArrayList<>(Stream.of(42, 99, 68, 24, 73, 62, 77, 55, 42)
                .filter(x -> x % 2 != 0)
                .collect(Collectors.toList()));
        System.out.println(l);
    }
}
