package main.java.example1;
//Reflection helps to inspect class/interface and its members and appropriatly modify as required. at runtime
//Reflection also helps create instances of classes at runtime(used in IOC)
//I dont understand this. does this mean reflection api code will be compiled at runtime ?

class MyClass { }

interface Intr { }


//below helps to understand how to initialize a java.lang.Class type variable and access its methods to inspect a custom class/interface properties.
public class TestReflection {

    // Technique 1: Using forName() method of Class class
    static void method1() throws ClassNotFoundException {
        System.out.println("From method1(): ");
        Class c = Class.forName("techguru.examples.MyClass");
        System.out.println(c.getName());
    }


    //Technique 2: Using getClass().getName() method of Object class
    static void method2() {
        System.out.println("\nFrom method2(): ");
        MyClass m = new MyClass();
        TestReflection t = new TestReflection();
        t.display(m);
    }

    void display(Object obj) {
        Class c = obj.getClass();
        System.out.println(c.getName());
    }

    //Technique 3: Using .class file extension and getName()
    static void method3() {
        System.out.println("\nFrom method3(): ");
        Class c1 = MyClass.class;
        System.out.println(c1.getName());

        Class c2 = TestReflection.class;
        System.out.println(c2.getName());
    }

    public static void main(String args[])  {
        try {
            method1();
        }
        catch (ClassNotFoundException ex) {
            ex.getMessage();
        }

        method2();

        method3();

        System.out.println("\nDetermining the interface or class object: ");
        try {
            Class c = Class.forName("techguru.examples.MyClass");
            System.out.println(c.isInterface());

            Class c2 = Class.forName("techguru.examples.Intr");
            System.out.println(c2.isInterface());

        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
