package linearsearch;

public class Main {
    public static void main(String[] args) {

        int[] nums = {20,10, 11,19};
        int target = 11;
        int ans = linear( nums, target);
        System.out.println(ans);

    }


      // Q1. question find the target element in array and return the index of the array.
    //
    static int linear(int arr[], int target){

        // case1 array has o elements
        if( arr.length == 0){
            return -1;
        }

        // case2- if found we need to return means we will be searching through all the array elements.

        for( int i = 0; i < arr.length; i++ ){
            if( arr[i] == target){
                return arr[i]; // return the element target
                // return i; - return index
            }
        }

        return -1;
    }

    // search the target and return the element
    static int linearSearch2(int[] arr, int target) {
        if (arr.length == 0) {
            return -1;
        }

        // run a for loop
        for (int element : arr) {
            if (element == target) {
                return element;
            }
        }
        // this line will execute if none of the return statements above have executed
        // hence the target not found
        return Integer.MAX_VALUE;
    }

    // search in the array: return the index if item found
    // otherwise if item not found return -1
    static int linearSearch(int[] arr, int target) {
        if (arr.length == 0) {
            return -1;
        }

        // run a for loop
        for (int index = 0; index < arr.length; index++) {
            // check for element at every index if it is = target
            int element = arr[index];
            if (element == target) {
                return index;
            }
        }
        // this line will execute if none of the return statements above have executed
        // hence the target not found
        return -1;
    }
}


// return true or false also we can do same code change the return type of the code.