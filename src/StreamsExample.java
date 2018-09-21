import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsExample {

    public static void main(String[] args) {
        /*
        Потоки (Stream) - последовательность элементов, которую
        можно обработать один раз, которая не обязательно хранится
        в памяти и потенциально даже может быть бесконечной.

        Примеры потоков:
        1) Любую коллекцию можно рассмотреть как поток, для этого
        у нее надо вызвать метод .stream()

        2) IntStream.range(1, 100) - поток, состоящий из int от 1
        до 99, еще есть IntStream.rangeClosed(1, 100) - от 1 до 100.

        3) Бесконечный поток единичек. Бесконечный поток случайных
        чисел.

        С потоками можно делать два вида операций
         - промежуточные
         - терминальные

        Промежуточные превращают поток в другой поток, описывают
        правило для превращения. Например, добавление 1 к каждому
        числу исходного потока.
        Другой пример промежуточной операции - фильтрация. Т.е.
        некоторые элементы исходного потока удаляются.

        Терминальные операции превращают поток в какое-то другое
        значение. Например, вычисление количества элементов в потоке.
        Или собрать поток в список (List). Или сложить все числа потока.
        Над одним потоком можно выполнить только одну терминальную
        операцию.
         */



        System.out.println(
                IntStream.rangeClosed(1, 10).sum()
        );
        System.out.println(
                //поток из фиксированных элементов
                Stream.of("abc", "xyz", "pq")
                    //собрать все элементы в список
                    .collect(Collectors.toList())
        );
        System.out.println(
                IntStream.range(1, 10)
                    .boxed() //int -> Integer
                    .collect(Collectors.toList())
        );

        System.out.println(
                //можно передать массив, кстати. Тогда
                //массив превратится в поток
                Stream.of("abc", "xyz", "pq")
                    //заменить все элементы по определенному
                    //правилу
//                    .map((String s) -> s + "!")
                    .map(s -> s + "!")
                    //функция в boolean, оставить ли элемент
                    .filter(s -> s.length() > 3)
                    .collect(Collectors.toList())
        );

        List<Integer> l1 = IntStream.range(1, 100)
                .skip(10) //пропустить первые 10 элементов потока
                .limit(20) // взять первые 20 элементов
                .boxed()
                .collect(Collectors.toList());
        //l1 - список от 11 до 30.
        System.out.println(l1);
        IntStream.range(1, 10)
                .map(x -> 2 * x)
                //действие для каждого элемента. int -> void
                .forEach(
                        x -> System.out.println(x)
                );

        Random r = new Random(42);
        IntStream.generate(() -> r.nextInt(2)).limit(100).forEach(System.out::println);
    }

}
