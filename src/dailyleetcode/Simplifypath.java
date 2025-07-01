package dailyleetcode;

import java.util.ArrayList;
import java.util.List;

public class Simplifypath {

    // LC - 71

    public static void main(String[] args) {


        String s = "/home/";
        System.out.println(simplifyPath(s));
    }

    public static String simplifyPath(String path) {
        String[] tokens = path.split("/");
        List<String> segments = new ArrayList<>();

        for (String token : tokens) {
            if (token.isEmpty() || token.equals(".")) {
                continue;
            } else if (token.equals("..")) {
                if (!segments.isEmpty()) {
                    segments.remove(segments.size() - 1);
                }
            } else {
                segments.add(token);
            }
        }

        // edge case handling if the string is empty
        if (segments.isEmpty()) {
            return "/";
        }

        StringBuilder result = new StringBuilder();
        for (String segment : segments) {
            result.append('/').append(segment);
        }

        return result.toString();
    }
}
