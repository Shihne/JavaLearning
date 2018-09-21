package objects;

/*
У каждого элемента класса (метода, поля, конструктора, ...)
есть модификатор доступа:
1) private    - виден только внутри класса
2) пустой     - виден только в пакете (в каталоге) класса
3) protected  - виден в пакете и в наследниках (см. наследование)
4) public     - виден везде
 */

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Student3 {
    //100% давайте поля делать только приватными.
    //Считается, что поля - это внутреннее состояние
    //объекта, к которому никто не должен иметь доступ,
    //чтобы случайно ничего не испортить.
    //Более того, считается, что не нужно даже говорить
    //другим классам, как устроено внутреннее состоние.
    //Может, мы не храним имя и курс в явном виде, может
    //мы их вообще берем из БД.

    private String name;
    private int course;

    //у нас методы и конструкторы почти всегда public.
    //приватными будем делать только вспомогательные методы
    //внутри класса, которые никто не должен иметь возможность
    //вызвать.

    public Student3(String name, int course) {
        this.name = name;
        this.course = course;
    }

    public void greet() {
        System.out.println(
                "Привет, я " + name + " с курса " + course
        );
    }

    public String getName() {
        return name;
    }

    //метод set часто не делают, тогда поле можно читать,
    //но не изменять.
    public void setName(String name) {
        this.name = name;
    }

    //Как написать то же самое для course
    //Alt + Ins

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }
}
