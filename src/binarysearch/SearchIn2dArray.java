package binarysearch;

// technquie 1 if it is sorted row wise and column

import java.util.Arrays;

public class SearchIn2dArray {

    public static void main(String[] args) {

        int[][] arr = {
                {2,6,30,40},
                {5,10,32,45},
                {11, 15, 36, 48},
        };
        int target = 36;
        System.out.println(Arrays.toString(search(arr,target))); // error got is directly used search() without using Arrays.toString(search)
     // as we know we need to convert it into the Strings everything.
    }

    public static int[] search(int[][] matrix, int target){

        int r = 0; // o simply lower bound ,
        int c = matrix.length - 1; // always gives the row length of the matrix
        // and main point to remember is that in any 2d or 3d or 4d , internally it is stored as 1d matrix of matrix
        // like continus form

        while( r < matrix.length && c >= 0){

            if(matrix[r][c] == target){
                return new int[]{r,c};
            }
            if( matrix[r][c] > target){
                c--;
            }
            else{
                r++;
            }
        }

        return new int[]{-1,-1};
    }
}
