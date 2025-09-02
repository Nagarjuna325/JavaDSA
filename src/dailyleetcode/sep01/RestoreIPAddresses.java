package dailyleetcode.sep01;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    public static void main(String[] args) {
        String s = "25525511135";
        System.out.println(restoreIpAddresses(s));
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        int n = s.length();
        if (n < 4 || n > 12) {
            return result;
        }

        for (int i = 1; i < 4; i++) {
            String first = s.substring(0, i);
            if (!isValid(first)) continue;
            for (int j = i + 1; j < i + 4 && j <= n; j++) {
                String second = s.substring(i, j);
                if (!isValid(second)) continue;
                for (int k = j + 1; k < j + 4 && k <= n; k++) {
                    String third = s.substring(j, k);
                    if (!isValid(third)) continue;
                    String fourth = s.substring(k);
                    if (isValid(fourth)) {
                        result.add(first + "." + second + "." + third + "." + fourth);
                    }
                }
            }
        }
        return result;
    }

    private static boolean isValid(String segment) {
        if (segment.length() > 1 && segment.charAt(0) == '0') {
            return false;
        }
        int num;
        try {
            num = Integer.parseInt(segment);
        } catch (NumberFormatException e) {
            return false;
        }
        return num >= 0 && num <= 255;
    }
}
