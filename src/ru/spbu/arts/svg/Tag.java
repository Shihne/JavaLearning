package ru.spbu.arts.svg;

import java.util.*;

public class Tag {
    private String name;
    private Map<String, String> attributes = new LinkedHashMap<>();
    private TagType type;

    public Tag(String name) {
        this.name = name;
        this.type = TagType.OPEN_AND_CLOSE;
    }

    public Tag(String name, TagType type) {
        this.name = name;
        this.type = type;
    }

    public void set(String parameter, String value) {
        attributes.put(parameter + "=\"", value + "\" ");
    }

    public String getName() {
        return name;
    }
    public Map<String, String> getAttributes() {
        return attributes;
    }
    public TagType getType() {
        return type;
    }
}
