package com.muks.oopsandjava.concepts.inheritance.up_and_down_casting;



public class Apple implements Fruit {
	public String variety;
	public String name;

	Apple(String name) {
		this.name = name;
	}


	static void test() {
		Fruit apple = new Apple("wood-apple");	/** Up-casting */
		Apple f = (Apple) apple;                /** Down casting, which has to be done manually */


        if (apple instanceof Fruit) {
            System.out.println("Apple instanceof fruit = True");
        }

        if (apple instanceof Apple) {
            System.out.println("False");
        }
		
	}
	
	
	public static void main (String[] args){
		test();
	}

	@Override
	public String getName() {
		return null;
	}
}
