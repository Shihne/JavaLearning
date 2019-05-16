package ru.spbu.arts.svg;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class SVG implements AutoCloseable{

    @Override
    public void close() {
        out.println("</svg>");
        out.close();
    }

    private PrintStream out;

    public SVG(String picture, int height, int width) throws FileNotFoundException, UnsupportedEncodingException {
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

}
