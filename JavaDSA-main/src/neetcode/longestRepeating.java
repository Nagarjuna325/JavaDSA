package neetcode;

import java.util.HashMap;
import java.util.concurrent.Executor;

public class longestRepeating {
    public static int characterReplacement(String s, int k) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            HashMap<Character, Integer> count = new HashMap<>();
            int maxf = 0;
            for (int j = i; j < s.length(); j++) {
                count.put(s.charAt(j), count.getOrDefault(s.charAt(j), 0) + 1);
                maxf = Math.max(maxf, count.get(s.charAt(j)));
                if ((j - i + 1) - maxf <= k) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }

    public static void main(String args[]) {
        String str = "AABABBA";
        System.out.println("The length of the longest repeating characters is " + characterReplacement(str, 2));

    }
}

//Executor