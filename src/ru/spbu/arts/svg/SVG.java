package ru.spbu.arts.svg;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

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
        out.println("<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"" + width + "\" height=\"" + height + "\">");
    }

    public void addTag(Tag tag) {
        StringBuilder s = new StringBuilder();
        s.append("<").append(tag.getName()).append(" ");
        List<String> content = tag.getContent();
        for (String parameter : content)
            s.append(parameter);
        s.append("/>");
        out.println("   " + s.toString());
    }

    public void close() {
        out.println("</svg>");
        out.close();
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
