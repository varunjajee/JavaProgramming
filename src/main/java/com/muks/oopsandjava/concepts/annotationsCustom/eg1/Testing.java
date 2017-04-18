package com.muks.oopsandjava.concepts.annotationsCustom.eg1;

import java.lang.reflect.Method;

/**
 * Created by 300000511 on 18/04/17.
 */
public class Testing {
    public static void main(String[] args) {

        Hello h = new Hello();
        Method m = null;
//        try {
//            m = h.getClass().getMethod("sayHello");
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }
//
//        SingleValueAnnotation manno = m.getAnnotation(SingleValueAnnotation.class);
//        System.out.println("value is: "+manno.value());

        h.sayHello();
    }


    //Applying annotation
    static class Hello{
        @SingleValueAnnotation(value=10)
        public void sayHello(){
            System.out.println("hello annotation");
        }
    }

}
