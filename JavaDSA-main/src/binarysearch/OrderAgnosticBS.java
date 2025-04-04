package binarysearch;

public class OrderAgnosticBS {

    public static void main(String[] args) {

        int[] arr = {-12, 21, 45, 56 , 65, 75, 89, 90};
        int target = 56;

        int ans = order(arr, target);

        System.out.println(ans);
    }

    static int order(int[] arr, int target){

        int start = 0;
        int end = arr.length - 1;

        boolean isAsc = arr[start] < arr[end];


        while( start <= end){

            // finding the middle element

            int mid =  start + (end - start) / 2 ; // why we took it like this? if we take directly start + end / 2 it may exceed the
            // range of the max capactiy of int in java.

            if( arr[mid] == target){
                return mid;
            }

            if(isAsc) {
                if (target < arr[mid]) {
                    end = mid - 1;
                } else  {
                    start = mid + 1;
                }
            } else{
                if (target > arr[mid]) {
                    end = mid - 1;
                } else  {
                    start = mid + 1;
                }
            }

        }
        return -1;
    }
}
