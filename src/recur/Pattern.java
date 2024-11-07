package recur;
import java.util.Scanner;
import java.util.*;
public class Pattern {

    public static void main( String[] args){

         //triangle( 5 , 0);

        // Creating a scanner object to take input for the scanner class
        //Scanner sc = new Scanner(System.in);

        // Prompt the user for input
        //System.out.print("Enter the number of rows for the triangle: ");
        //int rows = sc.nextInt();
        // Call the triangle function with user input
       // triangle1(rows, 0);

        // Close the scanner to avoid resource leaks
       // sc.close();

        int[] arr = {4, 3, 2,1};
        bubblesort(arr, arr.length-1, 0);
        System.out.println(Arrays.toString(arr));
    }

    static void triangle(int r , int c){

        if( r == 0){
            return ;
        }
        if (c < r) {
            System.out.print("* ");
            triangle( r , c + 1);
        } else{
            System.out.println( );
            triangle( r-1, 0);
        }
    }

    static void triangle1(int r , int c){

        if( r == 0){
            return ;
        }
        if (c < r) {
            triangle1( r , c + 1);
            System.out.print("* ");

        } else{
            triangle1( r-1, 0);
            System.out.println( );

        }
    }

    static void bubblesort(int[] arr, int r , int c){

        if( r == 0){
            return ;
        }
        if (c < r) {

            if( arr[c] > arr [c+1]) {

                int temp = arr[c];
                arr[c] = arr[c+1];
                arr[c+1] = temp;
            }
            bubblesort( arr,  r , c + 1);
        } else{
            bubblesort( arr, r-1, 0);


        }
    }
}
