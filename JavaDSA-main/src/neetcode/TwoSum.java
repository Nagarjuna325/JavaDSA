package neetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSum {

    public static List<int[]> bruteForce(int[] nums, int target) {
        List<int[]> result = new ArrayList<>();


        // Edge case Checking if array is null or has less than 2 elements
        if (nums == null || nums.length < 2) {
            System.out.println("Array must have at least two numbers.");
            return result; // Returns empty list
        }

        // Checking for all possible pairs we can form with the array elements

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result.add(new int[]{i + 1, j + 1});
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

       // Test Cases we can add
        int[] nums = {1, 7, 5, 12, 14, 21, 3, 22, 4};
        int target = 26;
        //TwoSum obj = new TwoSum();
        printResult(nums, target);


    }


    // helper function to print the results
    public static void printResult(int[] nums, int target){
        List<int[]> result = bruteForce(nums, target);

        // Correctly print all pairs in the result list

        if (result.isEmpty()) {
            System.out.println("No pairs found for given target in the array " + target);
        } else {
            for (int[] pair : result) {
                System.out.println(Arrays.toString(pair));
            }
        }

    }
}


// Brute Froce approach to with return type as array
// and also as a List
// TC - O(N*N)
// SC - O(1)




//public int[] twoSum(int[] nums, int target) {
//
//
//    // Edge case: Checking if array is null or has less than 2 elements
//    if (nums == null || nums.length < 2) {
//        return new int[0]; // Returning empty array
//    }
//
//    // initailzed an array of size double the length of the array
//    int[] result = new int[nums.length * (nums.length - 1)/2];
//    int count = 0;
//
//    for (int i = 0; i < nums.length - 1; i++) {
//        for (int j = i + 1; j < nums.length; j++) {
//            if (nums[i] + nums[j] == target) {
//                result[count++] = i + 1;
//                result[count++] = j + 1;
//
//            }
//        }
//    }
//
//    return Arrays.copyOf(result, count);
//    // If no solution is found that means combining any of the two elements in the array we are unable to get target value.
//}
//
//
//
//
//int[] nums1 = {2, 7, 11, 15};
//int target1 = 9;
//int[] result1 = new TwoSum().twoSum(nums1, target1);
//        System.out.println(Arrays.toString(result1));  // Output: [0, 1]
//
//int[] nums2 = {1, 7, 5, 12, 14, 21, 3, 22, 4};
//int target2 = 26;
//int[] result2 = new TwoSum().twoSum(nums2, target2);
//        System.out.println(Arrays.toString(result2));  // Output: [0, 1]
