package main.java.example3;
import main.java.example3.custom_annotation.NameValidation;
import main.java.example3.custom_annotation.SampleAnnotation1;
import main.java.example3.modal.AnnotationModal;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnotationProcessorMain {

    public static void main(String[] args){
        AnnotationModal modal=new AnnotationModal();
        modal.setName("harish123");
        String regex="^[a-zA-Z0-9]+$";   // alphanumeric group
        try {
            Class c = Class.forName("main.java.example3.modal.AnnotationModal");

            //start with processing field annotation
            Field field=c.getDeclaredField("name");
            NameValidation nameValidation= field.getAnnotation(NameValidation.class);
            if (nameValidation!=null){
                if(modal.getName().matches(regex)){
                    System.out.println("input validation success");
                }
            }

            //move to method annotation processing
            Method[] arr=c.getMethods();

            for (Method m:arr) {
                //check which method has the required annotation defined.
                SampleAnnotation1 s=m.getAnnotation(SampleAnnotation1.class);
                if (s!=null){
                    System.out.println("annotation read and processed on method1");
                    modal.method1();

                }
            }

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }


    }
}
