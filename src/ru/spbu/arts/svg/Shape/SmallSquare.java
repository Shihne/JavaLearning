package ru.spbu.arts.svg.Shape;

import ru.spbu.arts.svg.Tag;

import java.util.ArrayList;
import java.util.List;

public class SmallSquare implements Shape {
    @Override
    public List<Tag> getTags() {
        Tag square = new Tag("rect");
        square.set("x", "-5");
        square.set("y", "-5");
        square.set("width", "10");
        square.set("height", "10");
        square.set("style", "stroke: #0f04d6; fill: #04d6d3");
        List<Tag> tags = new ArrayList<>();
        tags.add(square);
        return tags;
    }
}
