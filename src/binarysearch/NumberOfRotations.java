package binarysearch;


// finding the count of rotations of the array
public class NumberOfRotations {

    // simply answer is pivot times.
    public static void main(String[] args) {

        int[] arr = {4,5,6,7,0,1,2,3};
        System.out.println(findPivot(arr));

        int count = findPivot(arr)+1;

        System.out.println(count);
    }


    public static int findPivot(int[] arr){

        int start = 0;
        int end = arr.length - 1;

        while(start <= end){

            // 4 cases
            int mid = start + (end - start)/2;

            if( mid < end && arr[mid] > arr[mid+1]  ){ // why the mid < end  because as we need to check the out of bound
                return mid;
            } if(mid < end && arr[mid] < arr[mid-1]){
                return mid-1;
            } if(arr[mid] <= arr[start]){
                end = mid - 1;
            }else{
                start = mid+1;
            }

        }
        return -1;
    }
}
