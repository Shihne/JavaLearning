package objects.interfaces_tasks;

import objects.drawings.Drawing;

public class Printables {
    public static void main(String[] args) {
        Drawing d = new Drawing(10, 2, '.');
        d.print();

        PrintableLetter pl = new PrintableLetter("x", 10);
        pl.print();

        PrintableString ps = new PrintableString("asdf");
        ps.print();

        System.out.println();
        Printable[] arr = new Printable[]{
                new Drawing(3, 4, 'a'),
                pl,
                ps,
                new Printable() {
                    @Override
                    public void print() {
                        System.out.println("0_0");
                    }
                },
                () -> System.out.println("OwO")
        };
        for (Printable a : arr)
            a.print();
    }
}
