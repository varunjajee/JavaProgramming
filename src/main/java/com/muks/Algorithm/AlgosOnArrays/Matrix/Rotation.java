package com.muks.Algorithm.AlgosOnArrays.Matrix;

/**
 * Created by mukthar.ahmed on 4/11/16.
 */
public class Rotation {

    public static void main(String[] args) {
        int[][] myMatrix = AMatrixUtils.getBasicMatrix();


        inplace_rotate(myMatrix);
    }

    public static void inplace_rotate(int[][] arr){
        inplace_transpose(arr);
        inplace_reflect(arr);
    }

    // pre: arr is square
    public static void inplace_reflect(int[][] arr){
        int size = arr.length;
        for(int k=0; k < size; k++){
            for(int i=0; i < Math.floor(size/2); i++){
                swap(arr, k, i, k, size-i-1);
            }
        }

        AMatrixUtils.printMatrix(arr);
    }

    // pre: matrix is square
    public static void inplace_transpose(int[][] arr){
        int size = arr.length;
        for(int diag = 0; diag < size; diag++){
            for(int i=diag+1; i<size; i++){
                swap(arr, diag, i, i, diag);
            }
        }

        AMatrixUtils.printMatrix(arr);
    }


    // Swaps elements of int array
    public static void swap(int[][] arr, int row1, int col1, int row2, int col2){
        int num1 = arr[row1][col1];
        int num2 = arr[row2][col2];
        arr[row1][col1] = num2;
        arr[row2][col2] = num1;
    }
}
