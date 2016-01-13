//package oops;
//
//public class Polymorphism {
//
//	/**
//	 * @param args
//	 */
//
//
//
//	public static void main(String[] args){
//		/*
//		 * It should be noted that in the first call to move(),
//		 * the reference type is Vehicle and the object being referenced is MotorBike.
//		 * So, when a call to move() is made, Java waits until runtime to determine which
//		 * object is actually being pointed to by the reference.
//		 * In this case, the object is of the class MotorBike. So, the move() method of MotorBike class will be called.
//		 * In the second call to move(), the object is of the class Vehicle. So, the move() method of Vehicle will be called.
//		 */
//
//		Vehicle vh=new MotorBike();
//		vh.move();    // prints MotorBike can move and accelerate too!!
//		vh=new Vehicle();
//		vh.move();    // prints Vehicles can move!!
//
//
//		// method overloading/run-time polymorphism
//		DemoOverload demo=new DemoOverload();
//		System.out.println(demo.add(2,3));      //method 1 called
//		System.out.println(demo.add(2,3,4));    //method 2 called
//		System.out.println(demo.add(2,3.4));    //method 4 called
//		System.out.println(demo.add(2.5,3));    //method 3 called
//
//
//
//	}	// end main()
//
//
//	public String add(int x, int y){  //method 5
//		return  String.valueOf(x+y);
//	}
//
//}	// end class - Polymorphism
//
//
////####################################################################################################
//// method overridding/run-time polymorphism
//class Vehicle{
//	public void move(){
//		System.out.println("Vehicles can move!!");
//	}
//}
//
////method overridding/run-time polymorphism
//class MotorBike extends Vehicle{
//	public void move(){
//		System.out.println("MotorBike can move and accelerate too!!");
//	}
//}
//
//// ####################################################################################################
//// Eg: method overloading/compile time polymorphism
//class DemoOverload {
//	public int add(int x, int y){  //method 1
//		return x+y;
//	}
//
//	public int add(int x, int y, int z){ //method 2
//		return x+y+z;
//	}
//
//	public int add(double x, int y){ //method 3
//		return (int)x+y;
//	}
//
//	public int add(int x, double y){ //method 4
//		return x+(int)y;
//	}
//
//
//	public String add(int x, int y){  //method 5	// this tends to be a valid case of over-riding. Ref: Cat.javapack
//		return  String.valueOf(x+y);
//	}
//
//
//}	// end class DemoOverload
//
//
//
