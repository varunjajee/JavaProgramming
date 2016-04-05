package com.muks.oopsandjava.concepts.inheritance.up_and_down_casting;

// this class will be extended @ Apple.javapack class
/*
 * One of the primary benefits of OOP is that you can create subclasses of (or extend) a class; 
 * the subclass then inherits all the properties and methods of the class. 
 * The subclass typically defines additional methods and properties or overrides methods or properties defined in the superclass. 
 * Subclasses can also override (provide their own definitions for) methods defined in a superclass.
 * One of the major benefits of using a superclass/subclass structure is that it is easier to reuse similar code 
 * between various classes.
*/
// superclass (Parent class)


interface Fruit {
	public String flavor = null;
	
	public String getName();
}


// subclass of parent class or superclass "Fruit"
/* 
public class Apple extends Fruit {
	public String variety;
	

}
*/


