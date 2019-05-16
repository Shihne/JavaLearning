package ru.spbu.arts.svg;

public class SVGDrawing {
    public static void main(String[] args) {
        Tag rect1 = new Tag("rect");
        rect1.set("x", "200");
        rect1.set("y", "200");
        rect1.set("width", "10");
        rect1.set("height", "20");
        rect1.set("style", "stroke: #ff0000; fill: #0000ff");

        Tag rect2 = new Tag("rect");
        rect2.set("x", "100");
        rect2.set("y", "250");
        rect2.set("width", "50");
        rect2.set("height", "35");
        rect2.set("style", "stroke: #000000; fill: #800080");

        try (
            SVG svg = new SVG("b.svg", 300, 300)) {
            svg.addTag(rect1);
            svg.addTag(rect2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
