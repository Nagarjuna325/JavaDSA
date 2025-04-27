package dailyleetcode;

import static java.lang.Math.max;

public class LongestSubArrayWithSumK {

    public static void main(String[] args) {
        int[] a = {2, 3, 5, 1, 9};
        long k = 10;
        int len = longest(a, k);
        System.out.println("The length of the longest subarray is: " + len);
    }


    // brute froce approach which will take approximately 0(n3) not exactly O(n3) why?
    public static int longest(int[] arr, long k){

        int n = arr.length;
        int l = 0;

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){

                // logic to find the sum of array equal to k
                int sum = 0;
                for(int m = i; m <= j; m++){
                    sum += arr[m];
                }
                if( sum == k){
                    l = max(l , j - i + 1);
                }
            }
        }
        return l;
    }


    // So we abserve carefully we can still see that we are using a for finding the sum of every new subarray which is a waste becuase again we are starting from the start
    // instead just we can add the j value to the previous once which will reduce the use of again one for loop - O(n2) time complexity now.

    public static int longest2(int[] arr, long k){

        int n = arr.length;
        int l = 0;

        for(int i = 0; i < n; i++){
            long sum = 0;
            for(int j = i; j < n; j++){
                // logic to find the sum of array equal to k
                sum += arr[j];
                if( sum == k){
                    l = max(l , j - i + 1);
                }
            }
        }
        return l;
    }
}
