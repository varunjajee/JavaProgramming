package com.muks.oopsandjava.concepts.DeepAndShallowCopy.DeepCopy;

import com.muks.oopsandjava.concepts.DeepAndShallowCopy.ShallowCopy.Course;

/**
 * Created by 300000511 on 19/04/17.
 */
public class DeepCopy {
    public static void main(String[] args) {
        DCCourse science = new DCCourse("Physics", "Chemistry", "Biology");

        Student student1 = new Student(111, "John", science);

        Student student2 = null;

        try {
            student2 = (Student) student1.clone();
        }
        catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
        }

        //Printing the subject3 of 'student1'

        System.out.println(student1.DCCourse.subject3);         //Output : Biology

        //Changing the subject3 of 'student2'

        student2.DCCourse.subject3 = "Maths";

        //This change will not be reflected in original student 'student1'

        System.out.println(student1.DCCourse.subject3);       //Output : Biology
        System.out.println(student2.DCCourse.subject3);       //Output : Biology
    }
}
