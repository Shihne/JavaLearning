package ru.spbu.arts.patterns.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLOutput;

public class ReflectionExample {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        String className = "ru.spbu.arts.patterns.reflection.A";
        Class<?> aClass = Class.forName(className);

        //List<String>
        //ещё один способ получить ссылку на класс: String.class,
        //это аналогично Class.forName("java.lang.String")
        Class<String> stringClass = String.class;
        //Т.е. тип Class параметризован тем классом, который он представляет
        //Но при использовании Class.forName мы, когда пишем программу,
        //не знаем, какой там будет тип, поэтому приходится писать
        //Class<?> или Class<? extends Object>

        //Итак, в переменной aClass мы храним информацию о классе A
        Object a1 = aClass.newInstance(); //outputs 'constructor 1'
        System.out.println(a1 instanceof A); //true

        //вызовем другой конструктор
        Constructor<?>[] aConstructors = aClass.getConstructors();
        Constructor<?> secondConstructor = aConstructors[1];
        Object a2 = secondConstructor.newInstance("Prisma");

        //System.out.println(((A) a2).getName()); //здесь надо заранее знать A
        Method getName = aClass.getMethod("getName"); //метод getName без параметров
        System.out.println(getName.invoke(a2)); //Prisma

        Method sayHello = aClass.getMethod("sayHello", int.class);
        //метод sayHello с int аргуметом
        sayHello.invoke(a2, 42); //a2.sayHello(42)
    }
}
