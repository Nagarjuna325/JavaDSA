package binarysearch;

public class SearchInRotatedArrayDuplicates {

    public static void main(String[] args) {

        int[] arr = {2,9,9,2,2,2};
        System.out.println(findPivot(arr));

        int target = 2;

        int ans = search(arr, target);

        System.out.println(ans);
    }


    public static int search(int[] nums, int target){


        //if you don't find the pivot, it means the array is not rotated
        int pivot = findPivot(nums);

        if(pivot == -1){
            // just do normal binary search
            return binary(nums, target, 0, nums.length -1);
        }

        // if pivot is found u found 2 asc sorted arrays
        // 3 cases
        if(nums[pivot] ==  target) {
            return pivot;
        }

        if( target > nums[pivot]){ // why the code fails we take target > nums[pivot] as we know 6 > 7 false so the next else condition will
            // execute which is  6 < 7

            return binary(nums, target, 0, pivot-1);  // what the mistake I made is that
            // here in the return statement if target is greater than pivot we know that right elements will be
            // for sure will be less than left right as the array is in asscending order.

        }

        return binary(nums, target, pivot+1, nums.length-1);




    }

    public static int binary(int[] arr, int target, int start, int end){

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

    // finding the pivot in a duplicate array

    public static int findPivot(int[] arr){

        int start = 0;
        int end = arr.length - 1;

        while(start <= end){

            // 4 cases
            int mid = start + (end - start)/2;

            if( mid < end && arr[mid] > arr[mid+1]  ){ // why the mid < end  because as we need to check preventing the out of bound
                return mid;
            } if(mid < end && arr[mid] < arr[mid-1]) {
                return mid - 1;
            }
//           if(arr[mid] <= arr[start]){
//                end = mid - 1;
//            }else{
//                start = mid+1;
//            }

                // if elements at middle, start , end are equal then skip the duplicates

                if( arr[mid] == arr[start] && arr[mid] == arr[end]) {  // [ 2, 9, 2,2,2]

                    // Skip the duplicates
                    // NOTE : what if these elements at start and end where the pivots??
                    // check if start is pivot

                    if( arr[start] > arr[start+1]){

                        return start;
                    }

                    start++;

                    if( arr[end] < arr[end-1]){
                        return end-1;
                    }

                    end--;
                }

                // left side is sorted, so pivot should be in right

            else if( arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end]) ){

                start = mid + 1;

                } else{
                     end = mid - 1;
                }


        }
        return -1;
    }
}
