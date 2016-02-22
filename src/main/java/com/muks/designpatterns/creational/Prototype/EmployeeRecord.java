package com.muks.designpatterns.creational.Prototype;

/**
 * Created by mukthar.ahmed on 12/28/15.
 */
public class EmployeeRecord implements Prototype {

    // some private object properties
    private int id;
    private String name, designation;
    private double salary;
    private String address;

    public EmployeeRecord(){
        System.out.println("   Employee Records of Oracle Corporation ");
        System.out.println("---------------------------------------------");
        System.out.println("Eid"+"\t"+"Ename"+"\t"+"Edesignation"+"\t"+"Esalary"+"\t\t"+"Eaddress");

    }

    public EmployeeRecord(int id, String name, String designation, double salary, String address) {
        this();
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
        this.address = address;
    }

    // major part of prototype design pattern
    @Override
    public Prototype getClone() {
        return new EmployeeRecord(id,name,designation,salary,address);
    }

    public void showEmployeeRecord(){
        System.out.println(id+"\t"+name+"\t"+designation+"\t"+salary+"\t"+address);
    }

}
