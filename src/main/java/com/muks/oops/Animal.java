package oops;

/*
 * abstract class can have both abstract and non-abstract methods/implemented
 */
public abstract class Animal {
	
	public String name="animal";//default
	
	private String id="1";

	abstract void walk();
	
	void shout() {
		System.out.println("+++ I shout in general...");
	}
	
	public boolean isLiving() {
		return true;
	}
	
	public int add (int a, int b) {
		return a+b;
	}
	
	// Encaptulation eg:
	// private String id => is encaptulated but is made available to the oops package by using access modifier - public setters and getters
	public String getId(){
		return id;
	}
	
	public void setId(String value){
		this.id=value;
	}
	
	
	
}
