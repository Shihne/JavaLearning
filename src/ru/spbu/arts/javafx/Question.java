package ru.spbu.arts.javafx;

public class Question {

    private int x;
    private int y;
    private int width;
    private int height;
    private String question;

    Question(int x, int y, int width, int height, String question) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.question = question;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    String getQuestion() {
        return question;
    }
}
