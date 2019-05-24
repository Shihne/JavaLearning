package ru.spbu.arts.svg;

import ru.spbu.arts.svg.Shape.Shape;

public class ShapeFactory {

    public Shape create(String description) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> aClass = Class.forName(description);
        Object shape = aClass.newInstance();
        if (shape instanceof Shape)
            return (Shape) shape;
        else {
            System.out.println("Конфигурация неверна");
            return null;
        }
    }
}
