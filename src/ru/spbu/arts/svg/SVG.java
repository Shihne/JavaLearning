package ru.spbu.arts.svg;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class SVG {
    private String picture;
    private int width;
    private int height;
    private PrintStream out;

    public SVG(String picture, int height, int width) throws FileNotFoundException, UnsupportedEncodingException {
        this.picture = picture;
        this.width = width;
        this.height = height;
        out = new PrintStream(picture, "UTF-8");
        out.println("<svg xmlns=\"http://www.w3.org/2000/svg\" width=" + width + " height=" + height + ">");
    }

    public void addTag(Tag tag) {

    }

    public void close() {
        out.println("</svg>");
    }


    public String getPicture() {
        return picture;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
