package oops;

public class StringPool {

	/**		Difference between 
	 * 		String str1 = "hello" (Called string literals, which are always ref to another object in the string pool)
	 * 		String str2 = "hello" 	=> str2 is assigned with the str1's object reference (mem ref)
	 * 		String str2 = new String("hello")	=> jvm here creates a new object in the string pool
	 * 
	 * 		"=="	=> compares if mem ref of both left & right object points to the same memory location
	 * 		".equals()" => compares objet contents
	 * 
	 * 
	 * 		"String Literal Pool" explaination at the bottom of the class file
	 * 
	 * 	Note: 
	 * 	-----
	 * 	.equals in java.lang.Object class is overridden at String class. .equals compares object contents, char by char
	 * 
	 */
	
	public static void main(String[] args) {

		String str1 = "Hello"; 
		String str2 = "Hello";
		str2 = str2.toUpperCase();
		
		System.out.println("str1 and str2 are created by using string literal."); 
		System.out.println(" str1 == str2 is " + (str1 == str2)); 
		System.out.println(" str1.equals(str2) is " + str1.equals(str2));
		System.out.println(" To upper case: " + str1 + " + " + str2);
	
	
	
		String str3 = new String("Hello"); 
		String str4 = new String("Hello"); 
		System.out.println("\n\nstr3 and str4 are created by using new operator."); 
		System.out.println(" str3 == str4 is " + (str3 == str4)); 
		System.out.println(" str3.equals(str4) is " + str3.equals(str4));
		
		
		
		String str5 = "Hel"+ "lo"; 
		String str6 = "He" + "llo"; 
		System.out.println("\n\nstr5 and str6 are created by using string constant expression."); 
		System.out.println(" str5 == str6 is " + (str5 == str6)); 
		System.out.println(" str5.equals(str6) is " + str5.equals(str6));
		
		
		
		String s = "lo";
		String str7 = "Hel"+ s; 
		String str8 = "He" + "llo"; 
		System.out.println("\n\nstr7 is computed at runtime."); 
		System.out.println("str8 is created by using string constant expression."); 
		System.out.println(" str7 == str8 is " + (str7 == str8)); 
		System.out.println(" str7.equals(str8) is " + str7.equals(str8));

		
	}


}


/*
 * String Literal Pool
 * String allocation, like all object allocation, proves costly in both time and memory. 
 * The JVM performs some trickery while instantiating string literals to increase performance and decrease memory overhead. 
 * To cut down the number of String objects created in the JVM, the String class keeps a pool of strings. 
 * Each time your code create a string literal, the JVM checks the string literal pool first. 
 * If the string already exists in the pool, a reference to the pooled instance returns.
 *  If the string does not exist in the pool, a new String object instantiates, then is placed in the pool. 
 *  Java can make this optimization since strings are immutable and can be shared without fear of data corruption
*
*	There is a table always maintaining a single reference to each unique String object in the global string literal pool 
*ever created by an instance of the runtime in order to optimize space. That means that they always have a reference to 
*String objects in string literal pool, therefore, the string objects in the string literal pool not eligible for garbage collection. 
*/
