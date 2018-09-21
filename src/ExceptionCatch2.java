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
        int x = readInt("введите x");
        int y = readInt("введите y");
        System.out.println("x + y = " + (x + y));
    }

    public static int readInt(String message) {
        System.out.println(message);
        int x;
        try {
            Scanner s = new Scanner(System.in);
            x = s.nextInt();
        } catch (Exception e) {
            System.out.println("введите заново");
        }
        return x;
    }
}
