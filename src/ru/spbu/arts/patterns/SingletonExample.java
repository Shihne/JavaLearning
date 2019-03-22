package ru.spbu.arts.semester.iv.patterns;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class SingletonExample {

    public static void main(String[] args) throws IOException {
        //хочется, чтобы в любом месте программы
        //был доступ к нескольким "глобальным"
        //объектам. Например, к настройкам
        //программы. Но настоящих глобальных
        //переменных в java нет.
        //Применим шаблон Singleton (Одиночка)
        //Реализуем с его помощью класс Settings

        //для получения доступа к настройкам
        //будем пользоваться статическим методом
        //класса Settings:

        Settings settings = Settings.getInstance();

        //метод getInstance() вернет нам
        //настройки программы. Любой вызов
        //getInstance возвращает всегда один и тот же объект
        //с настройками, т.е. во время работы программы
        //должно гарантироваться, что существует ровно один
        //объект класса Settings. Потому что настройки одни,
        //не может быть несколько разных наборов настроек.
        //Именно это гарантируется шаблоном Singleton:
        //он следит за тем, что в программе может быть ровно
        //один объект заданного класса.

        //new Settings(); - в частности, вызов конструктора
        //нужно запретить

        //Runtime - это синглетон, это окружение нашей
        //программы
        Runtime.getRuntime().exec("C:/windows/notepad.exe");

        //Desktop позволяет запускать файлы
        //в связанных приложениях. docx откроется в Word.
        //Desktop тоже синглетон
        Desktop.getDesktop().open(new File("abc.docx"));
    }

}
