package ru.spbu.arts.svg;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

public class Settings {

    private static Settings instance = new Settings();
    private Properties p = new Properties();

    private Settings() {
        try {
            p.load(new InputStreamReader(
                    new FileInputStream("svg.properties"), StandardCharsets.UTF_8
            ));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Settings getInstance() {
        return instance;
    }

    public String getBackground() {
        return p.getProperty("background");
    }

    public int getWidth() {
        return Integer.parseInt(p.getProperty("width"));
    }

    public int getHeight() {
        return Integer.parseInt(p.getProperty("height"));
    }

    public Map<String, Integer> getShapesWithCount() {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (String s : p.getProperty("draw").split(" "))
            map.put(s.split(":")[0], Integer.parseInt(s.split(":")[1]));
        return map;
    }

    public String getShapeDescription(String shape) {
        return p.getProperty("shape." + shape);
    }

    public long getRandSeed() {
        String rand_seed = p.getProperty("rand_seed");
        if (!rand_seed.equals("auto"))
            return Long.parseLong(rand_seed);
        else
            return 0;
    }
}
