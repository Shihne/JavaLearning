package ru.spbu.arts.svg;

import ru.spbu.arts.svg.Shape.PositionedShape;
import ru.spbu.arts.svg.Shape.Shape;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SettingsTesting {
    public static void main(String[] args) {
        Settings settings = Settings.getInstance();
        ShapeFactory shapeFactory = new ShapeFactory();
        long rand_seed = settings.getRandSeed();
        Random r = new Random();
        if (rand_seed != 0)
            r.setSeed(rand_seed);

        try (SVG svg = new SVG("e.svg")) {
            List<Shape> shapes = new ArrayList<>();
            settings.getShapesWithCount().forEach((key, value) -> {
                for (int i = 0; i < value; i++) {
                    try {
                        shapes.add(new PositionedShape(shapeFactory.create(settings.getShapeDescription(key)), r.nextInt(settings.getWidth()), r.nextInt(settings.getHeight())));
                    } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                        e.printStackTrace();
                    }
                }
            });
            /*for (int i = 0; i < 10; i++)
                shapes.add(new PositionedShape(shapeFactory.create(settings.getShapeDescription("small_square")), r.nextInt(settings.getWidth()), r.nextInt(settings.getHeight())));*/
            Collections.shuffle(shapes);
            for (Shape shape : shapes)
                shape.draw(svg);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
