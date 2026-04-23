package dailyleetcode.Year2026.April;

public class Problem219 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        int k = 3;

        Problem219 obj = new Problem219();
        System.out.println(obj.containsNearbyDuplicate(arr, k));
    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j <= i + k && j < n; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }

        return false;
    }
}
