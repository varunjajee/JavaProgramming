package com.muks.oopsandjava.concepts.DeepAndShallowCopy.ShallowCopy;

/**
 * Created by 300000511 on 19/04/17.
 */
public class Student implements Cloneable {
    public int id;
    public String name;
    public Course course;

    public Student(int id, String name, Course course) {
        this.id = id;

        this.name = name;

        this.course = course;
    }

    //Default version of clone() method. It creates shallow copy of an object.

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
