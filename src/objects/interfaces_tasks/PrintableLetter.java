package objects.interfaces_tasks;

public class PrintableLetter implements Printable {

    private String letter;
    private int count;

    public PrintableLetter(String letter, int count) {
        this.letter = letter;
        this.count = count;
    }

    @Override
    public void print() {
        for (int i = 1; i <= count; i++)
            System.out.print(letter);
        System.out.println();
    }



}
