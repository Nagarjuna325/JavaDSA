package dailyleetcode;

import java.util.HashMap;
import java.util.Map;

public class CountGoodSubarray {

    public static void main(String[] args) {
        // Test input
        int[] nums = {1, 5, 2, 5, 3, 2, 5, 6};
        int k = 3;

        // Call the method
        long result = countGood(nums, k);

        // Print the result
        System.out.println("Number of good subarrays: " + result);
    }

    public static long countGood(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        long pairCount = 0;
        long goodSubarrays = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            int currentNum = nums[right];
            int currentFreq = freqMap.getOrDefault(currentNum, 0);
            pairCount += currentFreq;
            freqMap.put(currentNum, currentFreq + 1);

            while (pairCount >= k) {
                goodSubarrays += nums.length - right;
                int leftNum = nums[left];
                int leftFreq = freqMap.get(leftNum);
                pairCount -= leftFreq - 1;
                freqMap.put(leftNum, leftFreq - 1);
                left++;
            }
        }

        return goodSubarrays;
    }
}
