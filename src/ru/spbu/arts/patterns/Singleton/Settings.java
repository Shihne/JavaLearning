package ru.spbu.arts.patterns.Singleton;

import javafx.scene.paint.Color;

public class Settings {

    //в этом поле хранится тот самый единственный объект
    //класса Settings
    private static Settings instance = new Settings();

    public static Settings getInstance() {
        return instance;
    }

    private Settings() {
        //загрузить настройки. Неважно как, например,
        //из файла, из Интернета, из БД
    }

    //пример полезной информации, содержащейся в
    //синглетоне
    public Color getBackground() {
        return Color.RED;
    }

    public String getUserName() {
        return "Ilya";
    }

}
