package sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args){

        int[] arr = { 1,7,8,6,1,9};
        int[] ans = mergeSort(arr);
        System.out.println(Arrays.toString(ans));

    }


     static int[] mergeSort(int[] arr){

        if( arr.length == 1){
             return arr;
        }

        int mid = arr.length/2;

        int[] left = mergeSort(Arrays.copyOfRange(arr, 0 , mid)); // creating a new object here using Arrays.copyofRange
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left , right);
     }


     static int[] merge(int[] first , int[] second){

        int[] mix = new int[first.length + second.length]; // new object we are creating

         int i = 0 ;
         int j = 0 ;

         int k = 0; // which is the pointer for new array formed from the merged 2 arrays

         while( i < first.length && j < second.length){

             if( first[i] < second[j]){

                mix[k] = first[i];
                i++;

             } else {
                 mix[k] = second[j];
                 j++;
             }
             k++; // so basically this condition is because after adding an element to the mix we need to move the pointer to the next location where it needs to store
            // so for moving ahead
         }

          // one more edge case
         // it may be possible that one of the array me be large size and their are some elements left in that array so add at the end

         // of the both loops only one will run as we know
         while( i < first.length) {

             mix[k] = first[i];
             i++;
             k++;
         }

         while( j < second.length) {

             mix[k] = second[j];
             j++;
             k++;
         }
         return mix;
     }

}

// what the Arrays.copyOfRange() function is doing

//    // Create the left and right arrays manually
//    int[] left = new int[mid];
//    int[] right = new int[arr.length - mid];
//
//// Copy elements into the left array
//    for (int i = 0; i < mid; i++) {
//        left[i] = arr[i];
//        }
//
//        // Copy elements into the right array
//        for (int i = mid; i < arr.length; i++) {
//        right[i - mid] = arr[i];
//        }
//
//        // Recursively call mergeSort on the left and right subarrays
//        left = mergeSort(left);
//        right = mergeSort(right);
//
