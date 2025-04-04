package binarysearch;

public class Ceiling {

    public static void main(String[] args){

        int[] arr = {-12, 21, 45, 56 ,58, 65, 75, 89, 90};
        int target = 57;

        int ans = ceiling(arr, target);

        System.out.println(ans);
    }

    public static int ceiling(int[] arr, int target){

        int start = 0;
        int end = arr.length - 1;

        while( start <= end){  // if the array is sorted and if it completed it search space by that time start will be
            // at ahead of end, this is also 2 pointer approach only if we observe carefully.

             // edge case 1:
            //but what if the target is greater than the greatest number in the array
            if( target > arr[arr.length-1]){
                return -1;
            }
            // finding the middle element


            int mid =  start + (end - start) / 2 ; // why we took it like this? if we take directly start + end / 2 it may exceed the
            // range of the max capactiy of int in java.

            if( target < arr[mid]){

                end = mid - 1;
            }
            else if( target > arr[mid]){
                start = mid + 1;
            }else{
                return arr[mid];
            }

        }

        return arr[start];  // when nothing from means everthing is failed then this will be running.
    }
}
