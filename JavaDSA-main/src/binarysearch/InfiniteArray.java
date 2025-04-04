package binarysearch;

public class InfiniteArray {

    public static void main(String[] args){

        int[] arr = {-12, 21, 45, 56 , 65, 75, 89, 90};
        int target = 56;

        int ans1 = ans(arr, target);

        System.out.println(ans1);
    }


    // Observe carefully the approach in this case

    static int ans(int[] arr, int target){

        // first start with a box of size 2
        int start = 0;
        int end = 1;

        // condition for the target to lie in the range
        while( target > arr[end]){

            int temp = end + 1;

            // double the bex value
            end = end + (end - start + 1) * 2;  // finding size of the array by using indices.( end - start + 1)
            start = temp;
        }

        return binary(arr, target, start, end);  // Observer here carefully the parameters are getting available to this method as
        // as the variables are declared in this method right.
    }


    //
    public static int binary(int[] arr, int target, int start , int end){


        while( start <= end){

            // finding the middle element

            int mid =  start + (end - start) / 2 ; // why we took it like this? if we take directly start + end / 2 it may exceed the
            // range of the max capactiy of int in java.

            if( target < arr[mid]){

                end = mid - 1;
            }
            else if( target > arr[mid]){
                start = mid + 1;
            }else{
                return mid;
            }

        }

        return -1;  // when nothing from means everthing is failed then this will be running.
    }

}
