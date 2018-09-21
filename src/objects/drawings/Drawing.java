package objects.drawings;

import objects.interfaces_tasks.Printable;
import java.util.Arrays;

public class Drawing implements Printable {
    private int ranks;
    private int columns;
    private char symbol;
    private char[][] picture;

    public Drawing(int ranks, int columns, char symbol) {
        this.ranks = ranks;
        this.columns = columns;
        this.symbol = symbol;
        char[][] picture = new char[ranks][columns];
        for (char[] line : picture)
            Arrays.fill(line, symbol);
        this.picture = picture;
    }

    public int getRanks() {
        return ranks;
    }
    public int getColumns() {
        return columns;
    }
    public char[][] getPicture() {
        return picture;
    }

    @Override
    public void print() {
        for (char[] line : picture) {
            for (char s : line)
                System.out.print(s + " ");
            System.out.println();
        }
    }

    public void setPoint(int x, int y, char marker) {
        picture[x - 1][y - 1] = marker;
    }

    public void drawVerticalLine(int x1, int x2, int y, char l) {
        for (int i = x1; i <= x2; i++)
            //picture[i - 1][y - 1] = l;
            setPoint(i, y, l);
    }
    public void drawHorizontalLine(int x, int y1, int y2, char l) {
        for (int i = y1; i <= y2; i++)
            //picture[x - 1][i - 1] = l;
            setPoint(x, i, l);
    }

    public void drawRectangle(int x1, int y1, int x2, int y2, char l) {
        drawVerticalLine(x1, x2, y1, l);
        drawVerticalLine(x1, x2, y2, l);
        drawHorizontalLine(x1, y1, y2, l);
        drawHorizontalLine(x2, y1, y2, l);
    }

    public void drawCircle(int x, int y, int radius, char l) {
        for (int i = 1; i <= ranks; i++)
            for (int j = 1; j <= columns; j++)
                if ((x - i) * (x - i) + (y - j) * (y - j) <= radius * radius) //x * x
                    //picture[i - 1][j - 1] = l; // setPoint здесь и везде
                    setPoint(i, j, l);
    }

    public void draw(int x, int y, Drawing d) {
        char[][] sticker = d.getPicture();
        int length;
        int width;

        if (ranks - x + 1 < d.getRanks())
            length = ranks - x + 1;
        else
            length = d.getRanks();
        if (columns - y + 1 < d.getColumns())
            width = columns - y + 1;
        else
            width = d.getColumns();

        for (int i = 0; i < length; i++)
            for (int j = 0; j < width; j++) //!!!
                //picture[x + i - 1][y + j - 1] = sticker[i][j];
                setPoint(x + i, y + j, sticker[i][j]);
    }

    public Drawing setPointInNew(int x, int y, char marker) {
        Drawing d = new Drawing(ranks, columns, symbol);
        d.setPoint(x, y, marker);
        return d;
    }
}
