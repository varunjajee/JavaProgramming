package com.muks.algo.additionalalgos;

public class PowerRaiseInt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		float x = 2;
		int y = -3;
		System.out.println(power(x, y) );

	}


	public static float power(float x, int y) {
		
		float temp;
		
		// base case for recurssion 
		if( y == 0) {
			return 1;
		}
		
		temp = power(x, y/2);
		
		if (y % 2 == 0) {
			return temp*temp;
		
		} else {
			if(y > 0) {
				System.out.println("+ Power: " + y + " Temp: " + temp);
				return x*temp*temp;
			
			} else {
				System.out.println("+ Power(< 0): " + y + " Temp: " + temp);
				return (temp*temp)/x;
			}
			
		}
	}  

}
