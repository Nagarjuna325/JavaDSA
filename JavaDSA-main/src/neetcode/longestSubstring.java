package neetcode;

import java.util.HashSet;


// in the diagram  left pointer is l, in code it is p1.
public class longestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int l = s.length();
        int p1 = 0;
        int max = 0;

        if( l <= 1){
            return 0;
        }

        HashSet<Character>  old = new HashSet<>();

        for(int r = 0; r < l; r++){

            while(old.contains(s.charAt(r))){
                old.remove(s.charAt(p1));
                p1++;
            }
            old.add(s.charAt(r));
            max = Math.max(max, r - p1 + 1);
        }

        return max;
    }


    // main method
    public static void main(String args[]) {
        //String str = "takeUforward";
        String str = "abcabcbb";
        System.out.println("The length of the longest substring without repeating characters is " + lengthOfLongestSubstring(str));

    }
}
