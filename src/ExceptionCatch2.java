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
    public static void main(String[] args) {
        int x = readInt("Введите x");
        int y = readInt("Введите y");
        System.out.println("x + y = " + (x + y));
    }

    public static int readInt(String message) {
        System.out.println(message);
        int x;
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        try {
            x = Integer.parseInt(str);
        } catch (Exception e) {
            x = readInt(str + " - это не число, попробуйте еще раз");
        }
        return x;
    }
}
