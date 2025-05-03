package dailyleetcode;

public class CountSubArrayWithK {

    // LEETCODE 2302 - 28TH


    // brute force code
    public static int countSubarrays2(int[] nums, long k) {
        int n = nums.length;
        int count = 0;

        for (int start = 0; start < n; start++) {
            long sum = 0;
            for (int end = start; end < n; end++) {
                sum += nums[end];  // Add the current element
                long score = sum * (end - start + 1);  // length = end - start + 1
                if (score < k) {
                    count++;
                } else {
                    // No need to go further if score already >= k
                    break;
                }
            }
        }

        return count;
    }

    // Optimized code sliding window code

    public static long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        int start = 0;
        long sum = 0;
        long count = 0; // Important to make count long

        for (int end = 0; end < n; end++) {
            sum += nums[end];

            // Shrink window until score < k
            while (start <= end && sum * (end - start + 1) >= k) {
                sum -= nums[start];
                start++;
            }

            // Number of subarrays ending at end is (end - start + 1)
            count += (end - start + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 4, 3, 5};
        int k = 10;
        System.out.println(countSubarrays(nums, k)); // Output: 6

        int[] nums2 = {1, 1, 1};
        int k2 = 5;
        System.out.println(countSubarrays(nums2, k2)); // Output: 5
    }


}
