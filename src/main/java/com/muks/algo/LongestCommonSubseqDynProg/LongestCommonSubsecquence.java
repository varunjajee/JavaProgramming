package com.muks.algo.LongestCommonSubseqDynProg;

public class LongestCommonSubsecquence {
	
	/*
	 * Usage: 
	 * 1. DNA subsecquence
	 * 2. Finding a closest word for a misspelt word in a dictionary
	 * 
	 * Algo - 1: ( no too fast as such ) - 2 to the power m
	 * Brute force algo: lets generate all possible subsecquences of A and then check which are also subsecqunece of B and
	 * then retain the longest 
	 * 
	 * Algo - 2:
	 * Dynamic programming
	 * 		1. 	Express the problem as a search problem - identify "the search space = common subsecquence of A & B"
	 * 			Objective - pick the longest one
	 * 		2. Write a recursive procedure.
	 * 				Search (s) {
	 * 					Divide S into subspaces S1, S2... Sn
	 * 					Find the longest/best in each
	 * 					Return the best of the best
	 * 				}
	 * 		3. characterize the recursive calls
	 * 	
	 */

	// ################################################################################################################
	/*
	 * Recursive solutions takes O(n * 2 power m) = slow!
	 */
	public static String LongestCommonSubseq (String a, String b){
	    int aLen = a.length();
	    int bLen = b.length();
	    

	    if(aLen == 0 || bLen == 0) {
	        return "";
	        
	    } else if (a.charAt(aLen-1) == b.charAt(bLen-1)) {
		    //System.out.println("\n++++ a.charAt(aLen-1) == b.charAt(bLen-1) " + a.charAt(aLen-1) + " == " + b.charAt(bLen-1) );
	        return LongestCommonSubseq (a.substring(0, aLen-1), b.substring(0,bLen-1) ) + a.charAt(aLen-1);
	        
	    } else {
		    //System.out.println("\n+ a.charAt(aLen-1) == b.charAt(bLen-1) " + a.charAt(aLen-1) + " == " + b.charAt(bLen-1) );
	        String x = LongestCommonSubseq(a, b.substring(0,bLen-1));
	        String y = LongestCommonSubseq(a.substring(0,aLen-1), b);
	        return (x.length() > y.length()) ? x : y;
	    }
	}

	// ################################################################################################################
	/* Precondition: Both x and y are non-empty strings.
	 * 
	 * Algo is using dynamic programming:
	 *
	 * Dynamic programming - when a problem can be divided into mutli smaller problems,
	 * then finding solutions to such smaller problems and solving them and keep building the solutions is called 
	 * dynamic programming
	 * 
	 *  The algo used here is memoization (not memorization) where we keep a memo of the solutions and check if 
	 *  we have already solved this problem so that we avoid repeated executions of problems
	 *  
	 *  There are two key attributes that a problem must have in order for dynamic programming to be applicable: 
	 *  optimal substructure and overlapping subproblems. 
	 *  If a problem can be solved by combining optimal solutions to non-overlapping subproblems, the strategy is called "divide and conquer" instead. 
	 *  This is why mergesort and quicksort are not classified as dynamic programming problems.
	 *  

	 *  O(m * n)
	 *
	 *  How to calculate the table for LCS using a theorem
	 *
	   C[i, j] = {
					- C[i-1, j-1] + 1 	if x[i] == y[j]
					OR
					Max { C[i, j-1], C[i-1, j] }

	   			}

	   which means;
	   C[i] = if i-th element == j-th element, then C[i]
	   else
	   C[j] = x[i] == y[j]
	   else it is C[i-1, j-1]
	   Or max of ( C[i, j-1], C[i-1, j] )
	*/
	
    public static void LcsByDynProg (String x, String y) {
        int M = x.length();
        int N = y.length();

        // opt[i][j] = length of LCS of x[i..M] and y[j..N]
        int[][] table = new int[M+1][N+1];

        // compute length of LCS and all subproblems via dynamic programming
        for (int i = M-1; i >= 0; i--) {
            for (int j = N-1; j >= 0; j--) {
            	System.out.println("\n Initial: i: " + i + " j: " + j + " => "+ table[i][j]);
            	System.out.println("  x: " + x.charAt(i) + " & y: " + y.charAt(j));
            	
                if (x.charAt(i) == y.charAt(j)) {
                    table[i][j] = table[i+1][j+1] + 1;
                
                    System.out.println(table[i][j]);
                    
                } else { 
                	System.out.println(" MAX:  " + table[i+1][j] + " , " + table[i][j+1]);
                	
                    table[i][j] = Math.max(table[i+1][j], table[i][j+1]);
                    
                    System.out.println(" opt[i][j] : " + table[i][j]);
                    
                }
            }
        }

        // recover LCS itself and print it to standard output
        int i = 0, j = 0;
        while(i < M && j < N) {
            if (x.charAt(i) == y.charAt(j)) {
                System.out.print(x.charAt(i));
                i++;
                j++;
            } else if (table[i+1][j] >= table[i][j+1]) {
            	i++;
            } else {                                 
            	j++;
            }
        }
        System.out.println();

    }


	// ################################################################################################################
	// Returns the greater of x and y.
	public static int max(int x, int y) {
		System.out.println(" x = " + x + ", y = " + y);
		if (x > y)
			return x;
		else
			return y;
	}
	
	
	// ################################################################################################################
	public static void main(String[] args) {
		String a = "abdefgh";
		String b = "abcefgh";
		String c = "nematode knowledge";
		String d = "empty bottle";
		
		String x = "ABCBDAB";
		String y = "BDCABA";
		LcsByDynProg(a, b);
		
		//System.out.println("\n+++ From dynamic programming: ");
		//lcsdyn(a, b);
		//System.out.println( LongestCommonSubseq(x, y) );
		
	}
	// ################################################################################################################
}
