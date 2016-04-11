package com.muks.Algorithm.AlgoBasics;

public class MultiplyWithOnlyArethematicOps {
	
	public static void main(String[] args) {
		System.out.println("+++ Product without arethematic operators: " + multiply(4, 4) );
	}
	
	
	static int multiply(int a, int b) {
		if(b == 0 || a == 0) {
			return 0;
		}
		else if (b == 1) {
			return a;
		}
		else {
			return a + multiply(a, b - 1);
		}
	}
}

// 2 + 3 + 2 + 2
