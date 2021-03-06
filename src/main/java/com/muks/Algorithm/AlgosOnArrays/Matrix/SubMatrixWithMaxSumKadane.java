package com.muks.Algorithm.AlgosOnArrays.Matrix;

/**
 *  Find the sub matrix with largest sum. Uses kadaneCompute's algorithm
 *
 *  Logic:
 *      - Get the sum of 0-th row and column and then compute cumulative sum of all cells
 */
public class SubMatrixWithMaxSumKadane {

    private static int[][] sumMatrix;

    public static void main(String[] args) {
        /** max sum = 15 */
        int[][] matrix2 = {
            {0, -2, -7, 0},
            {9, 2, -6, 2},
            {-4, 1, -4, 1},
            {-1, 8, 0, -2}
        };

        /** max sum = 9 */
        int[][] matrix1 = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };

        findMaxSum(matrix2);
    }


    public static Result findMaxSum(int input[][]){
        int rows = input.length;
        int cols = input[0].length;
        int temp[] = new int[rows];

        Result result = new Result();

        /** Set the left column */
        for (int left = 0; left < cols ; left++) {
            for (int i=0; i < rows; i++) {  /** init temp array with 0s */
                temp[i] = 0;
            }

            /** Set the right column for the left column, set by outer loop */
            for (int right = left; right < cols; right++) {

                /** Calculate sum between current left and right for every row 'i' */
                for (int i=0; i < rows; i++) {
                    System.out.println("# i = " + i +", right = " + right);
                    System.out.println("# temp = " + temp[i] + ", " + input[i][right]);
                    temp[i] += input[i][right];
                }
                
                KadaneResult kadaneResult = kadaneCompute(temp);
                System.out.println("");

                if (kadaneResult.maxSum > result.maxSum) {
                    result.maxSum = kadaneResult.maxSum;
                    result.leftBound = left;
                    result.rightBound = right;
                    result.upBound = kadaneResult.start;
                    result.lowBound = kadaneResult.end;
                }
            }
        }

        System.out.println("# Result = " + result.toString());
        return result;
    }

    private static KadaneResult kadaneCompute(int[] arr) {
        printArray(arr);

        int max = 0;
        int maxStart = -1;
        int maxEnd = -1;
        int currentStart = 0;
        int currMax = 0;

        for(int i=0; i < arr.length; i++){
            currMax += arr[i];

            if(currMax > max) {
                maxStart = currentStart;
                maxEnd = i;
                max = currMax;
            }
            else if (currMax < 0) {
                currMax = 0;
                currentStart = i+1;
            }

        }
        return new KadaneResult(max, maxStart, maxEnd);
    }

    static class KadaneResult{
        int maxSum;
        int start;
        int end;
        public KadaneResult(int maxSum, int start, int end) {
            this.maxSum = maxSum;
            this.start = start;
            this.end = end;
        }
    }

    static class Result{
        int maxSum;
        int leftBound;
        int rightBound;
        int upBound;
        int lowBound;
        @Override
        public String toString() {
            return "Result [maxSumPath=" + maxSum + ", leftBound=" + leftBound
                + ", rightBound=" + rightBound + ", upBound=" + upBound
                + ", lowBound=" + lowBound + "]";
        }

    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" "+ arr[i]);
        }
        System.out.println("");
    }
}
