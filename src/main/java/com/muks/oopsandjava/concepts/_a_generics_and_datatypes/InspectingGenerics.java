package com.muks.oopsandjava.concepts._a_generics_and_datatypes;


import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mukthar.ahmed on 5/27/16.

   Topic - Java generics
        How to inspect what generic type is for a List<> object

 */

public class InspectingGenerics {
    List<Figure> figuresList = new ArrayList<>();


    public static void main(String[] args) {
        new InspectingGenerics().testingGenerics();
    }


    public void testingGenerics() {

        Field stringListField = null;
        try {
            stringListField = InspectingGenerics.class.getDeclaredField("figuresList");

            ParameterizedType stringListType = (ParameterizedType) stringListField.getGenericType();
            Class<?> stringListClass = (Class<?>) stringListType.getActualTypeArguments()[0];
            System.out.println(stringListClass); // class java.lang.String.

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }


    interface Figure {
        public void whoAmI();
    }	// end MyClass

    class Circle implements Figure {
        public void whoAmI() {
            System.out.println("# I am a Circle.");
        }
    }

    class Square implements Figure {
        public void whoAmI() {
            System.out.println("# I am a Square.");
        }
    }

    class Rectangle implements Figure {
        public void whoAmI() {
            System.out.println("# I am a Rectangle.");
        }
    }
}
