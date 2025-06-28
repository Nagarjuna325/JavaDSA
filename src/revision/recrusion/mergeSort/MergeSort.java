package revision.recrusion.mergeSort;

import java.util.Arrays;

//  05/14/2025
public class MergeSort {

    public static void main(String[] args) {

        int[] arr = {5,4,3,2,1};
         mergeSortInPlace(arr, 0, arr.length);

        // So see this sorting method we are doing is not in place Sorting as we are creating a new array every time and getting the sorted array original array
        // remains of same.
        System.out.println( Arrays.toString(arr));

    }

    static int[] mergeSort(int[] arr){
        if( arr.length == 1){
            return arr;
        }

        int mid = arr.length/2;

        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));  // we are creating a new copy of array everytime we create a array.
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    static int[] merge(int[] first, int[] second){

        int[] mix = new int[first.length + second.length];

        int i = 0;
        int j = 0;
        int k = 0;


        while( i < first.length && j < second.length){

            if(first[i] < second[j]){
                mix[k] = first[i];
                i++;
            }else{
                mix[k] = second[j];
                j++;
            }
            k++;
        }

        // Now it may be possible that one of the arrays is not complete

        while( i < first.length){
            mix[k] = first[i];
            i++;
            k++;
        }
        while( j < second.length){
            mix[k] = second[j];
            j++;
            k++;
        }

        return mix;
    }

    // 2nd Method using in INPLACE SORT so space complexity is O(1) instead of O(N) which is in the above

    static void mergeSortInPlace(int[] arr, int s, int e){

        if( e - s  == 1){
            return;
        }

        int mid  = (s+e)/2;

        mergeSortInPlace(arr, 0, mid);
        mergeSortInPlace(arr, mid, e);

        mergeInPlace(arr, s, mid, e);
    }

    static void mergeInPlace(int[] arr, int s, int mid, int e){

        int[] mix = new int[e-s];

        int i = s;
        int j = mid;
        int k = 0;

        while( i < mid && j < e){

            if( arr[i] < arr[j]){
                mix[k] = arr[i];
                i++;
            }else{
                mix[k] = arr[j];
                j++;
            }
            k++;
        }


        while( i < mid){
            mix[k] = arr[i];
            i++;
            k++;
        }

        while( j < e){
             mix[k] = arr[j];
             j++;
             k++;
        }

        // So now the modified array is in mix array so now we need to copy this into the actual array.
        for( int l = 0; l < mix.length; l++){
            arr[s+l] = mix[l];
        }

    }
}
