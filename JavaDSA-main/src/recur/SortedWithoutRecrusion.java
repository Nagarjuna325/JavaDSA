package recur;

public class SortedWithoutRecrusion {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 6, 8, 0};
        System.out.println(sorted(arr));
    }

    public static boolean sorted(int[] arr){

        int n = arr.length;

        if( n==0){
            return true;
        }
        int count =0;
        for(int i = 0; i < n - 1; i++){
            if( arr[i] <= arr[i+1]){
                count++;
            }else{
                return false;
            }
        }

        if(count == n - 1)
            return true;

        return false;
    }
}
