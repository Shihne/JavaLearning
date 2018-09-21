package objects.abstractinheritance;

public class Cat extends Animal {

    public Cat() {
        super("Мурзик");
        System.out.println("nya");
    }

    public Cat(String name) { super(name); }

    private int miceCount = 0; //сколько поймано мышей
    public void catchAMouse() {
        miceCount++;
        System.out.println(getSound() + ", " + miceCount);
    }

    @Override
    public String getSound() {
        return "Nyaa";
    }
}
