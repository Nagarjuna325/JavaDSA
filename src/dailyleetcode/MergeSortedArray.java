package dailyleetcode;

import java.util.Scanner;

public class MergeSortedArray {

    // LC 88 problem

    public static void main(String[] args) {
        // Example input
        int[] nums1 = {1, 3, 5, 0, 0, 0}; // Extra space for nums2
        int m = 3; // Number of initialized elements in nums1
        int[] nums2 = {2, 4, 6};
        int n = 3; // Number of elements in nums2

        // Merge nums2 into nums1
        merge(nums1, m, nums2, n);

        // Print the merged array
        System.out.print("Merged Array: ");
        for (int num : nums1) {
            System.out.print(num + " ");
        }
        Scanner in = new Scanner(System.in);
        System.out.println(in.next());

        char ch = in.next().trim().charAt(0);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; // Pointer for the end of nums1's initialized part
        int j = n - 1; // Pointer for the end of nums2
        int k = m + n - 1; // Pointer for the end of nums1's total space

        // Merge from the end
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--]; // Place nums1[i] at the end
            } else {
                nums1[k--] = nums2[j--]; // Place nums2[j] at the end
            }
        }

        // Copy remaining elements from nums2 (if any)
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
