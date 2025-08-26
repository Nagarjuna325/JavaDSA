package binarysearch;

public class RotationCount {

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(countRotations(arr));
    }

    static int countRotations(int[] arr){
        int pivot = findPivot(arr);
        return pivot+1;
    }

    // finding the pivot without duplicates and when the array is rotated.
    static int findPivot(int[] arr){

        int start = 0;
        int end = arr.length-1;

        while( start <= end){
            int mid = start + (end - start)/2;

            if(arr[mid] > arr[mid+1]){ // case 1
                return mid;
            }if( arr[mid] < arr[mid - 1]){
                 return mid-1;
            } if( arr[mid] <= arr[start]){
                end = mid - 1;
            } else{
                start = mid + 1;
            }
        }

        return -1;

    }

    // finding the pivot when we have duplicates.
    static int findPivotWithDuplicates(int[] arr){

        int start = 0;
        int end = arr.length-1;

        while( start <= end){
            int mid = start + (end - start)/2;

            if(arr[mid] > arr[mid+1]){ // case 1
                return mid;
            }if( arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }
//            } if( arr[mid] <= arr[start]){
//                end = mid - 1;
//            } else{
//                start = mid + 1;
//            }
                // if the

            if( arr[mid] == arr[start] && arr[mid] == arr[end]){

                if( arr[start] > arr[start + 1]){
                    return start;
                }
                start++;

                if( arr[end] < arr[end - 1]){
                    return end-1;
                }
                end--;
            }

            else if( arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end]) ){

                start = mid + 1;

            } else{
                end = mid - 1;
            }


        }

        return -1;

    }

}
