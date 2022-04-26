package main.java.example2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//The following example demonstrates how to access class private/public members: the constructor, fields(access and update) and methods(access and invoke) of a class.
class Sample {

    private double pi;

    public Sample()  {
        pi = 3.14;
    }
    public void showPI()  {
        System.out.println("PI: " + pi);
    }

    public void powerOf2(int n)  {
        System.out.println("2^" + n + " is: " + Math.pow(2, n));
    }

    private void print() {
        System.out.println("Bye from Reflection.");
    }
}

public class TestingReflection {

    public static void main(String[] args) throws Exception {

        //reflection api looks up and loads the class (i.e java.lang.Class datatype)
        Class c = Class.forName("techguru.examples.Sample");

        //prints the fully-qualified class name
        System.out.println("Name of the class: " + c.getName());

        //load and prints the constructor name.
        Constructor constructor = c.getConstructor();
        System.out.println("Name of constructor: " + constructor.getName());

        //creates new instance to access members.
        Object obj = c.newInstance(); // what's the diff with new operator? is it same??

        //load and get the field.
        Field field = c.getDeclaredField("pi");
        //updating field value, irrespective of access specifier.
        field.setAccessible(true); //allows to change properties of access specifier, and access even if its private.
        field.set(obj, 3.142);

        //returns returns the method class instance
        Method m = c.getDeclaredMethod("showPI", null);

        //sets the accessibility of the method
        m.setAccessible(true);

        //used to invoke the method showPI()
        m.invoke(obj, null);

        //parameterized method powerOf2() called
        m = c.getDeclaredMethod("powerOf2", new Class[]{int.class});
        m.setAccessible(true);
        m.invoke(obj,7);

        //private method print() called
        //if no arguments, pass null value
        m = c.getDeclaredMethod("print", null);
        m.setAccessible(true);
        m.invoke(obj, null);

    }

}
