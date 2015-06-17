package oops;

public class PassByValues {

	/*	NOW let's look at passing values to methods 
	 * 
	 * Java is pass-by-value. Always.
	 * => That means "copy the value, and pass the copy."
	 * 
	 * For primitives, it's easy:
	 */
	
	public static void main(String[] args) {
		
		Integer a = 10;
		reset(a);
		System.out.println(a);
		
		Dog d = new Dog();
		System.out.println(d.type);
		d.type="Dabour";
		System.out.println(d.type); //you are passing the reference of the object, but still it is pass by value (the value is value of mem location)
	}

	private static void reset(Integer a) {
		a = 20;		
	}

}
