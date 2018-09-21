package objects.interfaces;

public class LambdasExample {

    public static void main(String[] args) {
        //создадим считателя.
        Counter c1 =  new Counter() {
            @Override
            public String count(int x) {
                return "*" + x;
            }
        };

        doCount(c1);

        Counter c2 = (int x) -> {
            return "(" + x + ")";
        }; //вместо анонимного класса пишем только
        //аргументы метода, потом стрелка, потом тело
        doCount(c2);

        //метод Integer.toString превращает в текст по основанию
        doCount(x -> Integer.toString(x, 2)); //как и раньше, тип параметра не нужен.
        //если в теле метода только return, можно без него
    }

    private static void doCount(Counter c) {
        for (int i = 1; i <= 10; i++)
            System.out.println(i + " -> " + c.count(i));
    }
}
