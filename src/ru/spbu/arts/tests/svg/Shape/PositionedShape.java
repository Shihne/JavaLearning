package ru.spbu.arts.tests.svg.Shape;

import ru.spbu.arts.tests.svg.Tag;
import ru.spbu.arts.tests.svg.TagType;

import java.util.ArrayList;
import java.util.List;

public class PositionedShape implements Shape {
    private Shape shape;
    private int x;
    private int y;

    public PositionedShape(Shape shape, int x, int y) {
        this.shape = shape;
        this.x = x;
        this.y = y;
    }

    @Override
    public List<Tag> getTags() {
        List<Tag> tags = new ArrayList<>();
        Tag g = new Tag("g", TagType.OPEN);
        g.set("transform", "translate(" + x + ", " + y + ")");
        tags.add(g);
        tags.addAll(shape.getTags());
        tags.add(new Tag("g", TagType.CLOSE));
        return tags;
    }

    public Shape getShape() {
        return shape;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
