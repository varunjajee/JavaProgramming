package oops;

public class EqualsMethodAndOperatorDiff {

	/**
	 * NOTE-1:
	 * ------- 
	 * the Ò==Ó operator is actually checking to see if the string objects (obj1 and obj2) refer to 
	 * the exact same memory location
	 * 
	 * NOTE-2:
	 * -------
	 * String str="Hello"; (string literal) or
	 * String str="Hel" + "lo"; (string constant expression). 
	 * 
	 * Difference is string compare operators
	 * 1) "="				=> 	deep comparision
	 * 2) "=="				=>	shallow comparision	: 	The == operator with reference types (i.e., Objects) evaluates 
	 * 													as true if the references are identical - point to the same object
	 * 3) .equals() method	=> 	object comparision	=> 	The equals method compares the content of two objects rather than two objects' references. 
	 * 
	 */
	
	public static void main(String[] args) {
		
		// EG: 1
		String obj1 = new String("xyz");
		String obj2 = new String("xyz");

		if(obj1 == obj2)
			System.out.println("obj1==obj2 is TRUE");
		else
			System.out.println("obj1==obj2 is FALSE");

		
		// now obj4 and obj3 reference the same place in memory
		// EG: 2
		
		String obj3 = new String("xyz");
		String obj4 = obj3;			// obj4 points to the same memory location as of obj3
		
		if(obj3 == obj4)
			System.out.println("obj1==obj2 is TRUE");
		else
			System.out.println("obj1==obj2 is FALSE");
		
		
		// Usage of .equals() method
		// Eg: 3
		/*
		 * The Java String class actually overrides the default equals() implementation 
		 * in the Object class Ð and it overrides the method so that it checks only the values of the strings, 
		 * not their locations in memory. This means that if you call the equals() method to compare 2 String objects, 
		 * then as long as the actual sequence of characters is equal, both objects are considered equal. 
		 * Here is an example that will help clarify this:
		 */
		if(obj1.equals(obj2))
		   System.out.println("\n .equals() => obj1==obj2 is TRUE");
		else
		  System.out.println("\n .equals() => obj1==obj2 is FALSE");
	
	}
	
}
