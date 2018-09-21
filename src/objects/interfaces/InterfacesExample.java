package objects.interfaces;

public class InterfacesExample {

    /*
    Интерфейсы - это абстрактные классы, в которых все методы
    абстрактные. Т.е. нет реализации ни одного метода.

    В Java нельзя наследоваться от нескольких классов. Но можно
    от нескольких интерфейсов.

    Колодец extends Строение, РезервуарДляВоды

    В Java так нельзя, если Строение и Резервуар для воды - классы
    Но можно, если это Интерфейсы.

    =================================

    Вообще, смысл интерфейса в том, что он описывает
    возможности класса.
     */

    public static void main(String[] args) {
        Animal c1 = new Cat("Барсик");
        // Animal a1 = new Animal(); нельзя
        Animal a2 = new Animal() {
            @Override
            public String getSound() {
                return "Ня";
            }

            @Override
            public String getName() {
                return "Барсик";
            }
        };
        //a2 - анонимный класс
    }
}
