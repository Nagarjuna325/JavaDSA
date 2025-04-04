package binarysearch;

public class BinarySearch {

    public static void main(String[] args){

        int[] arr = {-12, 21, 45, 56 , 65, 75, 89, 90};
        int target = 56;

        int ans = binary(arr, target);

        System.out.println(ans);
    }

    public static int binary(int[] arr, int target){

        int start = 0;
        int end = arr.length - 1;

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
