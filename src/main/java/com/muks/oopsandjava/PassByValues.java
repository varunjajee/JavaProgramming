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

//				Integer a = 10;
//				reset(a);
//				System.out.println(a);
//
//				Dog d = new Dog();
//				System.out.println(d.type);
//				d.type="Dabour";
//				System.out.println(d.type); //you are passing the reference of the object, but still it is pass by value (the value is value of mem location)

				Balloon red = new Balloon("Red"); //memory reference 50
				Balloon blue = new Balloon("Blue"); //memory reference 100

				swap(red, blue);
				System.out.println("red color="+red.getColor());
				System.out.println("blue color="+blue.getColor());
//
//				foo(blue);
//				System.out.println("blue color="+blue.getColor());

		}

		private static void reset(Integer a) {
				a = 20;
		}

		private static void foo(Balloon balloon) { //baloon=100
				balloon.setColor("Red"); //baloon=100
				balloon = new Balloon("Green"); //baloon=200
				balloon.setColor("Blue"); //baloon = 200
		}

		//Generic swap method
		public static void swap(Object o1, Object o2){
				Object temp = o1;
				o1=o2;
				o2=temp;
		}


		public static class Balloon {
				private String color;
				public Balloon() {}

				public Balloon(String c){
						this.color = c;
				}

				public String getColor() {
						return color;
				}

				public void setColor(String color) {
						this.color = color;
				}
		}
}
