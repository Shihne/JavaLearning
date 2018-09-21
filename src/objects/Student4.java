package objects;

public class Student4 {

    //переменная для подсчета числа студентов
    private static int count = 0;
    public static int getStudentsCount() {
        // System.out.println(name);
        //из статического метода нельзя обращаться к
        //не статическим элементам класса.

        //а наоборот? Можно
        return count;
    }
    public static final double PI = 3.14;
    //static final поле часто делают публичным, это "константы"

    private  String name;
    private int course;
    private final boolean b;

    public Student4(String name, int course) {
        this.name = name;
        this.course = course;
        System.out.println("Я создался! " + name);
        count++; //обновить кол-во студентов

        b = true; //значение final поля можно задать сразу или в конструкторе.
    }

    public  String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

}
