package ru.spbu.arts.svg.Shape;

import ru.spbu.arts.svg.SVG;
import ru.spbu.arts.svg.Settings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ShapesDrawing {
    public static void main(String[] args) {
        try (SVG svg = new SVG("d.svg")) {
            Settings settings = Settings.getInstance();
            long rand_seed = settings.getRandSeed();
            Random r = new Random();
            if (rand_seed != 0)
                r.setSeed(rand_seed);

            List<Shape> shapes = new ArrayList<>();
            for (int i = 0; i < 100; i++)
                shapes.add(new PositionedShape(new SmallSquare(), r.nextInt(400), r.nextInt(400)));
            for (int i = 0; i < 150; i++)
                shapes.add(new PositionedShape(new RedCircle(), r.nextInt(400), r.nextInt(400)));
            Collections.shuffle(shapes);
            for (Shape shape : shapes)
                shape.draw(svg);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
