package neetcode;

import java.util.*;

public class TargetElements {

    public static List<int[]> findPairs(int[] nums, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<int[]> resultList = new ArrayList<>();

        // Edge Case checking if array is empty or has only one element
        if (nums == null || nums.length < 2) {
            System.out.println("Array must have at least two numbers.");
            return resultList; // returns result
        }

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // If complement exists, add all possible pairs
            if (map.containsKey(complement)) {
                for (int index : map.get(complement)) {
                    resultList.add(new int[]{index + 1, i + 1}); // 1-based index
                }
            }

            // Store the index for the current number
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        return resultList;
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 5, 12, 14, 21, 3, 22, 4};
        int target = 26;
        printResult(nums, target);

    }


    // helper function to printResult so that no repetition of code.
    public static void printResult(int[] nums, int target) {
        List<int[]> result = findPairs(nums, target);


        if (result.isEmpty()) {
            System.out.println("No pairs found for given target in the array " + target);
        } else {
            for (int i = 0; i < result.size(); i++) {
                System.out.print(Arrays.toString(result.get(i)));
                if (i != result.size() - 1) System.out.print(", ");
            }
        }
    }
}



// O(n) Time Complexity - average case , O(N*N) - worst case
// O(n) Space Complexity - worst case

