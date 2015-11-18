package com.muks.oops;


import com.muks.oops.Animal;

public class Dog extends Animal {

		private String name = "Mogambo";
		public String type="Bull Dog";

		public String getName() {
				return this.name;
		}

		@Override
		public void walk() {
				System.out.println(this.name);	// gets value current/this class property.
				System.out.println(super.type);	// gets value from the super/parent class - NOTE: same goes
				// with method. this.method-name or super.method
				System.out.println("I walk with 4 legs");
		}

		@Override
		public void shout() {
				System.out.println("bhow bhow");
		}

		// ##############
		// this is the case of overridding where the signture, return type and the method name should be a exact match
		// and the implementation should be different than the super class
		@Override
		public boolean isLiving() {
				return false;	// this is overriding the implementation of the super/parent class
		}

		// ######################################################
		// Case of OVERLOADING, since we see a different param/signature
		public boolean isLiving(String name) {
				return true;

		}


		// invalid case of overloading and overriding
		//	public String isLiving() {
		//		return "";
		//
		//	}


		// Few more eg's for overloading
		// (1)
		public int add (int a, int b) {
				return b;
		}

		// (2)
		int add (int a, int b, int c) {
				return c;

		}

		// (3)
		int add (float a, int b) {
				return 1;
		}

		// (1-a) => this is a invalid case of overloading
		//	String add (int a, int b) {
		//		return "a";
		//	}


		// 	1. Rule/Note: Overloading say, only over the param's - signature of the method should be different
		//	2.  irrespective of the return type
}
