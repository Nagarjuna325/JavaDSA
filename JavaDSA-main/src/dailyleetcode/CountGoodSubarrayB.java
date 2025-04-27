package dailyleetcode;

import java.util.ArrayList;
import java.util.List;

public class CountGoodSubarrayB {
    public static void main(String[] args) {
        int[] nums = {1, 5, 2, 5, 3, 2, 5, 6};
        int k = 3;

        int goodSubarrays = 0;

        for (int start = 0; start < nums.length; start++) {
            for (int end = start; end < nums.length; end++) {
                // Build subarray
                List<Integer> subarray = new ArrayList<>();
                for (int i = start; i <= end; i++) {
                    subarray.add(nums[i]);
                }
                int pairs = countPairs(subarray);
                if (pairs >= k) {
                    goodSubarrays++;
                    System.out.println("Good Subarray: " + subarray + " Pairs: " + pairs);
                }
            }
        }

        System.out.println("Total Good Subarrays: " + goodSubarrays);
    }

    public static int countPairs(List<Integer> subarray) {
        int count = 0;
        for (int i = 0; i < subarray.size(); i++) {
            for (int j = i + 1; j < subarray.size(); j++) {
                if (subarray.get(i).equals(subarray.get(j))) {
                    count++;
                }
            }
        }
        return count;
    }


    public long countGood(int[] nums, int k) {
        int n = nums.length;
        long goodSubarrays = 0;

        // Go through all possible subarrays
        for (int start = 0; start < n; start++) {
            for (int end = start; end < n; end++) {
                int count = 0;

                // Count number of pairs (i, j) in current subarray where i < j and nums[i] == nums[j]
                for (int i = start; i <= end; i++) {
                    for (int j = i + 1; j <= end; j++) {
                        if (nums[i] == nums[j]) {
                            count++;
                        }
                    }
                }

                // If count of pairs >= k, this is a good subarray
                if (count >= k) {
                    goodSubarrays++;
                }
            }
        }

        return goodSubarrays;
    }
}
