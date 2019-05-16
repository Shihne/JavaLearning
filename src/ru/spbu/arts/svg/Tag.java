package ru.spbu.arts.svg;

import java.util.ArrayList;
import java.util.List;

public class Tag {
    private String name;
    private List<String> content = new ArrayList<>();

    public Tag(String name) {
        this.name = name;
    }

    public void set(String parameter, String value) {
        content.add(parameter + "=\"" + value + "\" ");
    }

    public String getName() {
        return name;
    }
    public List<String> getContent() { return content; }
}
