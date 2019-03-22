package ru.spbu.arts.patterns.adapter;

public class Car {

    private String name;

    //Alt + Ins
    public Car(String name) {
        this.name = name;
    }

    public String go() {
        return "ron don don, I'm " + name;
    }

    //Alt + Ins
    public String getName() {
        return name;
    }
}
