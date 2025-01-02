package sorting;

import java.util.Arrays;

// Inplace sorting this also

public class QuickSort {

    public static void main(String[] args){

          int[] nums = {4, 6,4,7,8};
          sort(nums , 0, nums.length-1);
          System.out.println(Arrays.toString(nums));

          //Arrays.sort(nums);

    }

    static void sort( int[] arr, int low, int hi){
        if(low >= hi){
            return;
        }
       // this s and e are for swapping and low and high are outside for the array
         int s = low;
        int e = hi;

        int mid = s + (e - s)/2;
        int pivot = arr[mid];


        while ( s <= e) {

            // also a reason why if its already sorted it will not swap
             while ( arr[s] < pivot) { // whis conditions are true keep moving ahead other go if and swap
                 s++;
             } while ( arr[e] > pivot ){
                 e--;
            }

             if( s <= e){
                 int temp = arr[s];
                 arr[s] = arr[e];
                 arr[e] = temp;
                 s++;
                 e--;

             }
        }

        // now my pivot is at correct index, please sort two halves now
        sort(arr , low , e);
        sort(arr, s, hi);

    }
}
