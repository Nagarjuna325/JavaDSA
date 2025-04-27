package HashMap;

public class Stringsearch {
    public static boolean isSubstring(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        if (m > n) return false; // Pattern longer than text cannot exist as a substring

        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break; // Mismatch found, move to the next starting index
                }
            }
            if (j == m) {
                return true; // Entire pattern found
            }
        }
        return false; // Pattern not found
    }

    public static void main(String[] args) {
        System.out.println(isSubstring("hello world", "world")); // Output: true
        System.out.println(isSubstring("hello", "ll")); // Output: true
        System.out.println(isSubstring("hello", "le")); // Output: false
        System.out.println(isSubstring("hello", "hello world")); // Output: false
    }


}
