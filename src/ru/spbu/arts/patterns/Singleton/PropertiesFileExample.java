package ru.spbu.arts.patterns.Singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class PropertiesFileExample {

    //удобный способ хранить настройки в файле
    public static void main(String[] args) throws IOException {
        //класс Properties - удобный способ хранить
        //настройки программы, сохранять, загружать их
        //их из файла

        Properties p = new Properties();
        //метод load позволяет загрузить настройки
        //Можно использовать FileInputStream - из файла
        //getResourceAsStream - загрузить из ресурсов
        p.load(new FileInputStream("example.properties"));
        p.load(new InputStreamReader(
                new FileInputStream("example.properties"),
                StandardCharsets.UTF_8
        ));

        //null если значения нет
        String name = p.getProperty("name");
        String age = p.getProperty("age");
        //значение по умолчанию
        String city = p.getProperty("city", "Moscow");
        System.out.println(name + " " + age + " " + city);
    }

}
