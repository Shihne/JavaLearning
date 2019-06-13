package ru.spbu.arts.tests.svg.Shape;


import ru.spbu.arts.tests.svg.SVG;
import ru.spbu.arts.tests.svg.Tag;

import java.util.List;

public interface Shape {

    List<Tag> getTags();

    default void draw(SVG svg) {
        for (Tag tag : this.getTags())
            svg.addTag(tag);
            }

}
