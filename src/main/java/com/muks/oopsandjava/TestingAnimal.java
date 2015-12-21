//package oops;
//
//
///*
// * SOME NOTES:
// * -----------
// * The method overriding is an example of runtime polymorphism.
// * You can have a method in subclass overrides the method in its super classes with the same name and signature.
// * Java virtual machine determines the proper method to call at the runtime, not at the compile time.
// *
// *
// * In Java, a variable declared type of class A can hold a reference to an object of class A or an object
// * belonging to any subclasses of class A.
// * The program is able to resolve the correct method related to the subclass object at runtime.
// * This is called the runtime polymorphism in Java. This provides the ability to override functionality already
// * available in the class hierarchy tree. At runtime, which version of the method will be invoked is based on the
// * type of actual object stored in that reference variable and not on the type of the reference variable.
// *
// *
// * Polymorphism is one in many forms. That�s it.....
// * Polymorphism allows you define a Super type and have multiple subtype implementations.
// *
// * There Are Two Types of Polymorphism in Java.
// *
// * 1. One is compile time Polymorphism and it is sometimes referred as static Polymorphism and - method overloading
// * 2. the other one is Runtime Polymorphism and it is sometimes referred as dynamic Polymorphism - method overriding
// *
// */
//
//public class TestingAnimal {
//
//	public static void main(String[] args) {
//
//		// Note-1: this is not possible as animal is abstract
//		//Animal animal = new Animal();
//
//		// Note-2: you can assign dog to animal, as dog is of type animal (IS-A relationship)
//		Animal dog = new Dog();
//
//		System.out.println(dog.isLiving());
//		System.out.println(((Animal)dog).isLiving()); //dog overrides isLiving method of Animal class from true to false
//
//		Animal cat = new Cat();
//		System.out.println(" Cat isLiving: "  + cat.isLiving()); //cat doesnt ovveride, so default of isLiving is true;
//
//		dog.walk();
//
//
//	}
//
//
//	public boolean add (int a, int b) {
//		return true;
//	}
//
//
////	public boolean add (int a, int b) {
////		return false;
////	}
//}
