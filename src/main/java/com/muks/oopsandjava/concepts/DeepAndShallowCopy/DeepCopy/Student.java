package com.muks.oopsandjava.concepts.DeepAndShallowCopy.DeepCopy;


import com.muks.oopsandjava.concepts.DeepAndShallowCopy.DeepCopy.DCCourse;

/**
 * Created by 300000511 on 19/04/17.
 */
public class Student implements Cloneable {
    public int id;
    public String name;
    public DCCourse DCCourse;

    public Student(int id, String name, DCCourse DCCourse) {
        this.id = id;
        this.name = name;
        this.DCCourse = DCCourse;
    }

    //Overriding clone() method to create a deep copy of an object.

    protected Object clone() throws CloneNotSupportedException {
        Student student = (Student) super.clone();
        student.DCCourse = (DCCourse) DCCourse.clone();
        return student;
    }
}