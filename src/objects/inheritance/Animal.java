package objects.inheritance;

public class Animal {

    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getSound() {
        return "pffffffff";
    }

    public void greet() {
        //вызывается getSound у объекта, а не класса. Т.е.
        //если вызывать
        System.out.println("Hello, I'm " + name + " " + getSound());
    }
}
