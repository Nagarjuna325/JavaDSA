package revision.recrusion.quickSort;

import java.util.Arrays;

public class QuickSort {

    // what is it?
    // why we use it?
    // How we do it?

    public static void main(String[] args) {

        int[] arr ={ 5, 4, 3, 2,1};
        sort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));


        Arrays.sort(arr);
    }

    // we are taking 2 pointers low and high tells which part of the array we are working on
    // start and end pointers we taking for swapping the elements
    static void sort(int[] nums, int low , int high){


        if( low >= high){
            return;
        }

        int s = low;
        int e = high;

        int m = s + (e-s)/2;

        int pivot = nums[m];

        while( s <= e) {
            while (nums[s] < pivot) {
                s++;
            }
            while (nums[e] > pivot) {
                e--;
            }

            // also a reason why we use Quick sort instead of merge SORT BECUASE if it is sorted it wont swap

            // why we are using this condition see in the above 2 while loops we are checking the condition if everything is good
            // condition is correct it won't come to this line if anything is not then this condition will be checked and executed
            if( s <=  e){

                int temp = nums[s];
                nums[s] = nums[e];
                nums[e] = temp;
                s++;
                e--;
            }
        }

     //now my pivot is at correct index , please sort two halves now.
        sort(nums, low, e);
        sort( nums, s, high);

    }

}
