package ru.spbu.arts.svg;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class SVGDrawing {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        SVG svg = new SVG("b.svg", 300, 300);

        Tag rect1 = new Tag("rect");
        rect1.set("x", "200");
        rect1.set("y", "200");
        rect1.set("width", "10");
        rect1.set("height", "20");
        rect1.set("style", "stroke: #ff0000; fill: #0000ff");

        svg.addTag(rect1);
        svg.close();
    }
}
