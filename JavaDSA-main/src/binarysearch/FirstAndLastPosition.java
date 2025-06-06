package binarysearch;

import java.util.Arrays;

public class FirstAndLastPosition {

    public static void main(String[] args) {

        int[] arr = {3, 4, 5, 5,7,7,7,7,9,8,9};

        int target = 7;

        int[] ans = searchRange(arr, target);

        System.out.println(Arrays.toString(ans));

    }

    public static int[] searchRange(int[] nums, int target){

        int[] ans = {-1, -1};
//        int[] nums = {3, 4, 5 , 6, 7, 7, 7,7,8, 70};
  //      int target = 7;
        int start = search(nums, target, true );
        int end = search(nums, target, false);

        ans[0] = start;
        ans[1] = end;

        return ans;
    }

    // using the helper function to find the first and last occurance of the number

    public static int search(int[] arr, int target, boolean findStartIndex){

         int ans = -1;
         int start = 0;
         int end = arr.length - 1;

         while( start <= end){

             int mid = start + (end - start)/2;

             if( target < arr[mid] ){
                 end = mid - 1;
             }else if( target > arr[mid]){
                 start = mid +1;
             } else{
                 // potential answer found
                 ans = mid;
                 // but there may be other potential answer at left side stikk
                 if( findStartIndex){
                     end = mid - 1;
                 } else{
                     start = mid + 1;
                 }
             }
         }

         return ans;
    }
}
