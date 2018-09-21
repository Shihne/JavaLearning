package objects.inheritance;

public class AnimalsExample {
    public static void main(String[] args) {
        Animal a1 = new Animal("Barsik");
        Animal a2 = new Animal("Bobik");
        Animal a3 = new Animal("Burenka");

        a1.greet();
        a2.greet();
        a3.greet();

        //Cat c1 = new Cat();
        //такой конструктор - странный. Животное нельзя создать,
        //не указав имя. А кот тоже животное, как же тогда у кота
        //имени нет??

        //Принцип конструирования объекта. При создании объекта
        //вызываются по очереди конструукторы всех базовых классов.
        //т.е. при создании Cat должен сначала вызваться конструктором
        //Animal, и только потом конструктор Cat.

        //Поэтому при наследовании в конструкторе потомка
        //обязательно вызывается конструктор предка.

        Cat c1 = new Cat();
        Cat c2 = new Cat("Барсик");
        c1.greet(); //Мурзик
        c2.greet(); //Барсик

        //Если в базовом классе есть конструктор без аргументов,
        //то можно ничего не писать, даже super.

        c1.catchAMouse();
        c1.catchAMouse();
        //a1.catchAMouse(); //в животном нет такой возможности

        Animal a5 = new Animal("Животное 1");
        Cat c3 = new Cat("Животное 2");

        System.out.println(a5.getSound()); //pffffff
        System.out.println(c3.getSound()); //Meow

        //Переменная базового класса может хранить объект класса
        //потомка
        Animal a6 = new Cat("Животное 3");
        System.out.println(a6.getSound()); //Meow, т.к. a6 - Кот

        //List<String> l = new ArrayList<String>().

        c1.catchAMouse();
        //a5.catchAMouse(); конечно, не работает
        //a6.catchAMouse(); не работает?! Т.к. тип a6 - Animal,
        //но у Animal нет метода catchAMouse

        //Но если мы точно значем, что a6 - это кот, как все-таки
        //вызвать этот метод?

        ((Cat)a6).catchAMouse(); //приведение типа
        Cat c6 = (Cat)a6; //объект один и тот же, но на него
        //указывают переменные разных типов

        //вообще, проверка типа делается оператором instanceof
        System.out.println(a6 instanceof Cat); //true
        System.out.println(a5 instanceof Cat); //false
    }
}
