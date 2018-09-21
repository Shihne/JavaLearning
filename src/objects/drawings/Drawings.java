package objects.drawings;

public class Drawings {
    public static void main(String[] args) {
        Drawing d = new Drawing(20, 30, '.');
        d.print();

        d.setPoint(5, 5, 'x');
        d.print();

        d.drawVerticalLine(3, 10, 15, '|');
        d.print();

        d.drawHorizontalLine(2, 2, 29, '-');
        d.print();

        Drawing d1 = new Drawing(7, 10, '.');
        d1.drawRectangle(3, 5, 7, 9, ' ');
        d1.print();

        Drawing d2 = new Drawing(10, 11, '.');
        d2.drawCircle(6, 4, 3, ' ');
        d2.print();

        d2.draw(1, 1, d1);
        d2.print();

        Drawing house = new Drawing(9, 13, ' ');
        house.drawRectangle(4, 3, 9, 11, '.');
        house.drawHorizontalLine(4, 1, 13, ',');
        house.setPoint(3, 2, '/');
        house.setPoint(3, 12, '\\');
        house.setPoint(2, 3, '/');
        house.setPoint(2, 11, '\\');
        house.drawHorizontalLine(1, 4, 10, '_');
        house.drawRectangle(6, 5, 8, 9, '.');
        house.print();

        Drawing d3 = new Drawing(3, 5 , 'j');
        Drawing d4 = d3.setPointInNew(2, 3, 'f');
        d4.print();
    }
}
