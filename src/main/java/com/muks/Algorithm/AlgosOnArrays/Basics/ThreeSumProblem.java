package com.muks.Algorithm.AlgosOnArrays.Basics;



public class ThreeSumProblem {
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// works on sorted array, else use any sorting technq to get it sorted before processing
		int[] arr = {-25, -1, -7, -3, 2, 4, 10, 10};		
		//int[] arr =  {-1, 0, 1, 2, -1, -4};

		int length = arr.length;

		for(int i=0; i<length; i++){
			int a = arr[i];
			int sec = i + 1;
			int last = length-1;

			while( sec < length ) {
				int b = arr[sec];
				int c = arr[last];
				
				if ( a+b+c == 0 ) {
					System.out.println( ""+a+"/"+b+"/"+c );
					System.exit(0);
				
				} else if ( a+b+c > 0 ){
					last--;
				
				} else{
					sec++;
				
				}
				
			}
		}
		System.out.println("not found");

	}

}
