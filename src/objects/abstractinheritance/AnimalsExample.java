package objects.abstractinheritance;

public class AnimalsExample {
    public static void main(String[] args) {
        //у абстрактного класса нельзя создать Объект

        //Animal a = new Animal("Шарик");
        //ошибка, потому что класс абстрактный.

        Animal a = new Cat("Шарик");
        //а вот так можно.

        Animal[] zoo = new Animal[]{
                new Cat("Барсик"),
                new Dog("Шарик"),
                //анонимные классы
                new Animal("Вуу") { //после оператора new сразу стоят
                    @Override             //фигурные скобки. Внутри них - тело
                    public String getSound() { //класса. Там могут быть поля,
                        return "Вууууу"; //методы. Это "безымянные классы",
                    }                    //потому что у них нет имени.
                }                        //Этот класс, зато, наследник Animal
        };

        for (Animal animal : zoo)
            animal.greet();
    }
}
