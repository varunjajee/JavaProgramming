package com.muks.Algorithm.AlgosOnArrays.Matrix;

/**
 * Created by 15692 on 14/06/16.
 */
public class RotateElementsClockWise {
    private static void rotateMatrix(int m, int n, int[][] mat){
        int i, j, top = 0, bottom = m-1, left = 0, right = n-1;
        int t=0, u=0;
        while(top < bottom && left < right){

            //moving top row
            u = mat[top+1][left];
            for(i=left; i<=right; i++){
                t = mat[top][i];
                mat[top][i] = u;
                u = t;
            }
            top++;


            // moving right column
            for(i=top; i<=bottom; i++){
                t = mat[i][right];
                mat[i][right] = u;
                u = t;
            }
            right--;


            // moving bottom row
            if(top <= bottom){
                for(i = right; i>=left; i--){
                    t = mat[bottom][i];
                    mat[bottom][i] = u;
                    u = t;
                }
                bottom--;
            }

            // moving left column
            if(left <= right){
                for(i=bottom; i>=top; i--){
                    t = mat[i][left];
                    mat[i][left] = u;
                    u = t;
                }
                left++;
            }
        }

        printMatrix(mat);
    }

    static void printMatrix(int[][] a){
        int i, j;
        for(i=0; i < a.length; i++){
            for(j=0; j < a[0].length; j++){
                System.out.format("%d ", a[i][j]);
            }
            System.out.println("\n");
        }
        System.out.println("\n\n");
    }


    public static void main(String[] args) {
        int a[][] = { {1,  2,  3,  4},
            {5,  6,  7,  8},
            {9,  10, 11, 12},
            {13, 14, 15, 16}  };

        int R = 3, C = 3;

//        // Test Case 2
//        int[][] a = {{1, 2, 3},
//            {4, 5, 6},
//            {7, 8, 9}
//        };


        rotateMatrix(R, C, a);
        //printMatrix(R, C, a);

    }
}
