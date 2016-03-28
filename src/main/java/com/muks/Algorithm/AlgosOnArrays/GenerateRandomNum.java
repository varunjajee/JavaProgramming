package com.muks.Algorithm.AlgosOnArrays;

public class GenerateRandomNum {

	
	// A function to randomly select a item from stream[0], stream[1], .. stream[i-1]
	public static int selectRandom(int x) {
	    int res = 0;    // The resultant random number
	    int count = 0;  //Count of numbers visited so far in stream
	 
	    count++;  // increment count of numbers seen so far
	 
	    // If this is the first element from stream, return it
	    if (count == 1)
	        res = x;
	    else
	    {
	        // Generate a random number from 0 to count - 1
	        int i = selectRandom(0, count);
	 
	        // Replace the prev random number with new number with 1/count probability
	        if (i == count - 1)
	            res  = x;
	    }
	    return res;
	}

	private static int selectRandom(int i, int count) {
		 int stream[] = {1, 2, 3, 4};
		    int n = stream.length/stream[0];
		 
		    // Use a different seed value for every run.
		    //srand(time(null));
		    for (int j = 0; j < n; ++j)
		        System.out.println("Random number from first %d numbers is %d \n" + j+1 + selectRandom(stream[j]));
		    return 0;
	}
}
