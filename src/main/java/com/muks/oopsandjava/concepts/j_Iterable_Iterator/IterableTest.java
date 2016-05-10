package com.muks.oopsandjava.concepts.j_Iterable_Iterator;

import java.util.Iterator;

/**
 * Created by mukthar.ahmed on 5/10/16.
 */
public class IterableTest {
    /**
     * Main method for the iteration along a list of students
     * @param args (no args expected)
     */
    public static void main(String[] args) {

        Students studentsList = new Students(4);
        studentsList.add(0, "David");
        studentsList.add(1, "Adam");
        studentsList.add(2, "Michael");
        studentsList.add(3, "Bob");

        for (Iterator<String> it = studentsList.iterator(); it.hasNext();)
            System.out.println(it.next());


        String str = "1234";
        Integer.parseInt(str);
    }
}
