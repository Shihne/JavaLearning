package ru.spbu.arts.svg.Shape;

import ru.spbu.arts.svg.Tag;

import java.util.ArrayList;
import java.util.List;

public class RedCircle implements Shape {
    @Override
    public List<Tag> getTags() {
        Tag circle = new Tag("circle");
        circle.set("r", "10");
        circle.set("style", "stroke: #660606; fill: #d60416");
        List<Tag> tags = new ArrayList<>();
        tags.add(circle);
        return tags;
    }
}
