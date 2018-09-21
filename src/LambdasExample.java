import java.io.File;
import java.util.Arrays;

public class LambdasExample {
    public static void main(String[] args) {

        //Сортировка массива (списка)

        String[] a = {"abc", "pq", "x", "oni"};
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));

        /*
        Компаратор, сравниватель. Волшебное устройство, которому можно дать две строки, и он говорит, какое из утверждений верно
        1) первая строка "больше" второй
        2) первая строка "меньше" второй
        3) первая строка "равна" второй

        Лексикографический компанатор сравнивает первую букву.
        Компанатор длин сравнивает строки их длинами.

        Компаратор, фактически, это функция
        //0 равно
        //1 или любое положительное означает, что s1 > s2
        //-1 или любое отрицательное означает, что s1 < s2
        int compare(String s1, String s2) {
            if (s1.length() > s2.length())
                return 1;
            if (s1.length() < s2.length())
                return -1;
        }
        int compare(String s1, String s2) {
            return s1.length() - s2.length();
        }
         */

        //вторым аргументом надо дать как-то ф-ию compare
        //функцию можно написать прямо внутри! И короче, чем
        //мы написали её выше.
        //Пишем аргументы функции, в скобках
        //ставим стрелку ->
        //пишем тело функции в фигурных скобках
        Arrays.sort(a, (String s1, String s2) -> {
            return s1.length() - s2.length();
        });
        System.out.println(Arrays.toString(a));

        //практически всегда можно не писать типы аргументов
        Arrays.sort(a, (s1, s2) -> {
            return s1.length() - s2.length();
        });
        System.out.println(Arrays.toString(a));

        //если единственно, что делает функция, это return,
        //то фигурные скобки и сам return можно не писать
        Arrays.sort(a, (s1, s2) -> s1.length() - s2.length());
        System.out.println(Arrays.toString(a));

        //Еще один пример lambda выражений.
        //Мы умеем смотреть список файлов в каталоге.
        //Отфильтруем файлы
        String[] files2 = new File("c:/windows").list(
                //фильтр, который определяет, какие файлы должны
                //быть выбраны
                /*  boolean filter(File folder, String fileName) {
                *       return fileName.endsWith(".exe");
                *   }
                 */
                /* (File folder, String fileName) -> {
                     return fileName.endsWith(".exe");
                   }
                */

                (folder, fileName) -> fileName.endsWith(".exe")
        );
        if (files2 != null)
            for (String file : files2)
                System.out.println(file);
    }
}
