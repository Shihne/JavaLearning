package ru.spbu.arts.svg.Shape;

import ru.spbu.arts.svg.SVG;

public class ShapesDrawing {
    public static void main(String[] args) {
        try {
            SVG svg = new SVG("d.svg", 300, 300);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
