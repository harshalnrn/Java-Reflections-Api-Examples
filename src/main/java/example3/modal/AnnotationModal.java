package main.java.example3.modal;

import main.java.example3.custom_annotation.NameValidation;
import main.java.example3.custom_annotation.SampleAnnotation1;

public class AnnotationModal {

    @NameValidation
    private String name;

    @SampleAnnotation1
    public void method1(){
        System.out.println("inside method1");
    }

    public void method2(){
        System.out.println("inside method2");
    }

    public void method3(){
        System.out.println("inside method3");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}



//annotation: class/method/field level