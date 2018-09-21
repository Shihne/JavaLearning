package objects;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StudentsExample {

    public static void main(String[] args) {

        //заведем две переменные, s1 и s2 для хранения
        //студентов. В каждой переменной хранится строка
        //и число.
        //Создание объекта. Оператор new
        Student s1 = new Student();
        Student s2 = new Student();

        //как получить доступ к name и course внутри s1 и s2
        s1.name = "Иванов";
        s2.name = "Петров";
        s1.course = 1;
        s2.course = 2;

        System.out.println(
                s1.name + " учится на курсе " + s1.course
        );

        // Различие классов и объектов.
        // Класс описывает шаблон устройства объекта.
        // Класс говорит, что в объектах есть такие-то данные
        // (поля) и такое-то поведение (методы)
        // Класс Student всегда один, потому что есть
        // только одно описание того, как устроены студенты.
        // Объекты - это реализации класса. Объектов может
        // быть любое количество, от 0 до много.
        // В нашей программе 2 объекта.
        // Объекты - это конкретные студенты, класс - это
        // само понятие "студент".

        // конструктор выделяет память для объекта, вызывается
        // оператором new: new Student

        Student s3 = s1;

        System.out.println(s3.name); //Иванов
        s3.name = "Иванова";
        System.out.println(s1.name); //Иванова

        //как вызвать метод:
        s1.greet(); //объект точка метод(), в методах
                    //всегда круглые скобки. s1.greet - то
                    //greet это ссылка на поле, а токого поля
                    //нет.
        s2.greet();

        //Конструкторы. Было бы здорово создать студента,
        //сразу указав ему и имя, и курс.
        Student2 ss2 = new Student2("Петрова", 3);
        ss2.greet();

        //значения полей по-умолчанию
        System.out.println(new Student().course); //0
        System.out.println(new Student().name); //null
        //базовые типы по-умолчанию нули.
        //объектные типы --- null

        System.out.println(new Student2().course); //1
        System.out.println(new Student2().name); //null

//        new File("a.txt");
//        new File("c:/windows", "a.txt");
//        "abc asd".split(" ");
//        "abc asd".split(" ", 2);

        //Использование класса с приватными полями
        Student3 sss = new Student3("Васильева", 4);
        //sss.name = "..."; // не работает :( name - приватный
        //System.out.println(sss.name); //тоже нет!!

        //чтобы узнать (изменить) имя, нужен метод
        //методы для того, чтобы узнать или изменить
        //значение свойств называются get- и set- методами.
        System.out.println(sss.getName()); //узнать имя
        sss.setName("Васильев"); //установить имя

        //-------------- 4. static ----------------------
        Student4 i4 = new Student4("Иванов", 1);
        Student4 p4 = new Student4("Петров", 2);

        //Объектов класса Student4: 2шт
        //класс Student4: 1 шт.
        //полей name внутри Student4: 2шт. (одно с Иванов,
        //другое - с Петров)

        /*
        static поле класса, в отличие от обычного поля,
        содержится в классе, а не в объекте. Т.е. оно существует
        в единственном экземпляре.

        static метод относится к классу, а не к объекту.
        Вызов:
         */
        System.out.println(Student4.getStudentsCount());

        //System.out.println()
        // System - класс
        // out - статическое поле (объект класса PrintStream)
        // метод println - обычный метод (не статический)

        p4.getStudentsCount(); //метод статический, но вызывается
        //у объекта, а не у класса. Это работает, но так писать
        //не рекомендуется, это нелогично.

        //Math.PI - статическое поле в классе math

        /*Ключевое слово final
        слово final можно дописывать при определении локальной переменной, поля, класса, метода.
        Для переменной или поля final означает, что значение (переменной или поля) нельзя изменять после присваивания

        Это примерно как в const в других языках.
         */

        final int n = 10;
        System.out.println(n); //можно читать
        //n = 42; //нельзя изменять

        //присваивание можно сделать не сразу, но надо сделать
        //присваивание перед первым обращением
        final int m;

        if (n > 5)
            m = 10;
    }
}
