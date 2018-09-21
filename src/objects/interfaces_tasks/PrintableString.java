package objects.interfaces_tasks;

public class PrintableString implements Printable {

    private String str;

    public PrintableString(String str){
        this.str = str;
    }

    @Override
    public void print() {
        System.out.println(str);
    }


}
