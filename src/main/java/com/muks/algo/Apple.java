package com.muks.algo;



public class Apple extends InheritanceFruit {
	public String variety;
	
	void test() {
		Apple a = new Apple();
		InheritanceFruit f = a;
		
		// This shows a invalid syntax coz downcasting is not allowed from Fruit to Apple
		// from superclass to subclass
		// Apple b = (InheritanceFruit)f; // downcasting is not allowed
		
		Apple b = (f instanceof Apple) ? (Apple)f : null;
		
	}
	
	
	public static void main (){ 
	
		
	}

}
