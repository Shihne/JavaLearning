package ru.spbu.arts.svg;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

public class SVG implements AutoCloseable{

    @Override
    public void close() {
        out.println("</svg>");
        out.close();
    }

    private PrintStream out;

    public SVG(String picture) throws FileNotFoundException, UnsupportedEncodingException {
        out = new PrintStream(picture, "UTF-8");
        Settings settings = Settings.getInstance();
        out.println("<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"" + settings.getWidth() + "\" height=\"" + settings.getHeight() + "\">");
        out.println("<rect x=\"0\" y=\"0\" width=\"" + settings.getWidth() + "\" height=\"" + settings.getHeight() + "\" style=\"fill: " + settings.getBackground() + "\" />");
    }

    public void addTag(Tag tag) {
        StringBuilder s = new StringBuilder();
        TagType type = tag.getType();
        if (type != TagType.CLOSE) {
            s.append("<").append(tag.getName()).append(" ");
            Map<String, String> attributes = tag.getAttributes();
            attributes.forEach((key, value) ->
                    s.append(key).append(value)
            );
            if (type != TagType.OPEN)
                s.append("/>");
            else
                s.append(">");
        } else
            s.append("</").append(tag.getName()).append(">");
        out.println("   " + s.toString());
    }

}
