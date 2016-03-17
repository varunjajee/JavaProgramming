package com.muks.algo.AlgosOnArrays.IntrvQuestions;

/**
 * Created by mukthar.ahmed on 3/18/16.
 * <p>
 * Q - Find the sub array with max sum
 * <p>
 * Logic:
 * - Keep traversing from left to right
 * - While traversing, track max_ending_here + arr[i] > 0 then init start index
 * - If any time, max_ending_here goes < 0, then reset all variables max_ending_here and max_so_far with st and end
 * indexes as well.
 */
public class MaxSubarrayKadaneAlgo {

    public int solution(int[] arr) {
        int max_so_far = 0;
        int MAX = 0;

        int st = 0;
        int end = 0;
        boolean flagStartFound = false;

        for (int i = 0; i < arr.length; i++) {

            MAX = MAX + arr[i];
            System.out.println("\nMAX = " + MAX);

            if (MAX > 0) {
                max_so_far = MAX;

                if ( !flagStartFound ) {
                    st = i;
                    flagStartFound = true;
                }

                end = i;
            }
            else {      /** reset all variables */
                max_so_far = 0;
                MAX = 0;
                st = i;
                flagStartFound = false;
            }

            System.out.println("Max = " + max_so_far + ", st=" + st + ", end=" + end);

        }

        System.out.println("\n+ Position in array : (" + st + ", " + end + ") with Max = " + max_so_far);

        return max_so_far;

    }


    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -9, -1, 1, 1, 1}; // change it with your input array
        //int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3}; // change it with your input array

        //int arr[] = {-6,2,-3,-4,-1,-5,-5};
        //int arr[]={-1,2,3,-3,4};

        MaxSubarrayKadaneAlgo kadaneAlgo = new MaxSubarrayKadaneAlgo();
        System.out.println(kadaneAlgo.solution(arr));
    }
}
