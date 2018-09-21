package objects.interfaces;

//интерфейсы реализуют (implements), а не расширяют (extends)
public class Cat implements Animal {

    private String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public String getSound() {
        return "meow";
    }

    @Override
    public String getName() {
        return name;
    }
}
