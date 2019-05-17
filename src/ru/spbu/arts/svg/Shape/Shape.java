package ru.spbu.arts.svg.Shape;

import ru.spbu.arts.svg.SVG;
import ru.spbu.arts.svg.Tag;

import java.util.List;

public interface Shape {

    List<Tag> getTags();

    default void draw(SVG svg) {
        for (Tag tag : new SmallSquare().getTags())
            svg.addTag(tag);
        for (Tag tag : new RedCircle().getTags())
            svg.addTag(tag);
    }
}
