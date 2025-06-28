package dailyleetcode;

import java.util.HashMap;
import java.util.Map;

public class CountLargestGroup {

    public static void main(String[] args) {
        CountLargestGroup sol = new CountLargestGroup();
        int n = 5; // You can change this value to test with different inputs
        int result = sol.countLargestGroup(n);
        System.out.println("Output: " + result);
    }

    public static int countLargestGroup(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;

        for (int i = 1; i <= n; i++) {
            int sum = digitSum(i);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            max = Math.max(max, map.get(sum));
        }

        int count = 0;
        for (int val : map.values()) {
            if (val == max) count++;
        }

        return count;
    }

    public static int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
