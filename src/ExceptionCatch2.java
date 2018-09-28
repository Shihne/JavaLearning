/*
метод Integer.parseInt("242") если это не чисто, то генерируется исключение
     -строка в число
     нужна функция int readInt(String message)

     использование
        int x = readInt("введите x");
        int y = --------//--------
        sout("x + y = " + (x + y))

     Чтобы читать с клав: s = new Scanner(System.in)
        s.nextLine()
 */

import java.util.Scanner;

public class ExceptionCatch2 {

    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int x = readInt("Введите x");
        int y = readInt("Введите y");
        System.out.println("x + y = " + (x + y));
    }

    private static int readInt(String message) {
        System.out.println(message);


        while (true) {
            String str = s.nextLine();
            try {
                return Integer.parseInt(str);
            } catch (Exception e) {
                System.out.println(str + " - это не число, попробуйте еще раз");
            }
        }



    }
}
