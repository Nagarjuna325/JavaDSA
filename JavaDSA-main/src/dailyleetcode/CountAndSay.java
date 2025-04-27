package dailyleetcode;

public class CountAndSay {


        public static void main(String[] args) {



            int n = 6;  // you can change this value to test different inputs
            String result = countAndSay(n);

            System.out.println("Count and Say for n = " + n + " is: " + result);
        }

        public static String countAndSay(int n) {
            if (n <= 0) return "-1";
            if (n == 1) return "1";

            String result = "1";  // base case

            for (int i = 2; i <= n; i++) {
                StringBuilder next = new StringBuilder();
                int count = 1;
                char prevChar = result.charAt(0);

                for (int j = 1; j < result.length(); j++) {
                    if (result.charAt(j) == prevChar) {
                        count++;
                    } else {
                        next.append(count).append(prevChar);
                        prevChar = result.charAt(j);
                        count = 1;
                    }
                }
                // for the last group
                next.append(count).append(prevChar);
                result = next.toString();
            }

            return result;
        }




}
