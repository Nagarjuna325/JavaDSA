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
}


// return true or false also we can do same code change the return type of the code.