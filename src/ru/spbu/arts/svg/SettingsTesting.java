package ru.spbu.arts.svg;

public class SettingsTesting {
    public static void main(String[] args) {
        Settings settings = Settings.getInstance();
        System.out.println(settings.getShapeDescription("small_square"));
    }
}
