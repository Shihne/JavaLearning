package ru.spbu.arts.svg.Shape;


import ru.spbu.arts.svg.SVG;
import ru.spbu.arts.svg.Tag;
import java.util.List;

public interface Shape {

    List<Tag> getTags();

    default void draw(SVG svg) {
        for (Tag tag : this.getTags())
            svg.addTag(tag);
            }

}
