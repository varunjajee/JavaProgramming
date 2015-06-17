package com.muks.algo;
/**
 * @author 
 *
 */
public class max_elemet_without_loop {
	

	static int a[] = {2,4,1,66,22,55};
	static int max = 0;
	static int len; 
	
	static void large (int n) {
		 if(a[n] > max )
			  max = a[n];
		
		
		if (n <len-1) {
			 large(n+1);
			 
			}

	}

	
	public static void main(String[] args) {
		
		// int a[] = {2,4,1,66,22,55}; 
		//len = a.length;
		large(2);
		System.out.println("len = " + max);
		

		}

}
