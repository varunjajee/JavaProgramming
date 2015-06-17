package com.muks.algo;

// this class will be extended @ Apple.java class
/*
 * One of the primary benefits of OOP is that you can create subclasses of (or extend) a class; 
 * the subclass then inherits all the properties and methods of the class. 
 * The subclass typically defines additional methods and properties or overrides methods or properties defined in the superclass. 
 * Subclasses can also override (provide their own definitions for) methods defined in a superclass.
 * One of the major benefits of using a superclass/subclass structure is that it is easier to reuse similar code 
 * between various classes.
*/
// superclass (Parent class)
class InheritanceFruit {
	public String flavor;
	
	public String getName() { 
		return getClass().getName();	
	}
	
}


// subclass of parent class or superclass "InheritanceFruit"
/* 
public class Apple extends InheritanceFruit {
	public String variety;
	

}
*/


