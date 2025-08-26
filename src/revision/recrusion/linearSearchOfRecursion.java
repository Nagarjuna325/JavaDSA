package revision.recrusion;


// Linear search using recursion
public class linearSearchOfRecursion {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 16, 8};
        System.out.println(linear(arr, 10, 0));

    }

    static boolean linear(int[] arr, int target, int index){

        if( arr.length == 0){
            return false;
        }

        if(arr[index] == target){
            return true;
        }

        if(index == arr.length - 1){
            return false;
        }

        return linear(arr, target, index+1);
    }

    // other way simple same only as above but using || OR operator.
    static boolean find(int[] arr, int target, int index){
        if(index == arr.length - 1){
            return false;
        }

        return arr[index] == target || find(arr, target, index+1);
    }
}
