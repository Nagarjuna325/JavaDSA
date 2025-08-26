package stringmatch;

public class Karp {


    // using substring method

    // but it creates a new substring everytime we use a the substring method so instead without substring is better than this.

    // firsst normal method for string matching
    // s1="kunal"
    // s2= " Raju kunal ravi" find s1 string exists in s2 or not

    // made a mistake kept return type but not the method so shown  as a comment
    boolean match(String s1 , String s2)
    {
        int l = s1.length();
        int n = s2.length();

        for( int i = 0 ; i <= n - l; i++){ // why only  n - l not n ? and for this for O(l) - TC


            // I thought in this
//            int count = 0;
//           while( count < l ) {
//               if (s1.charAt(i) == s2.charAt(i)) {
//                   return true;
//               }
//               count++;
//           }

//            if (s1.charAt(i) == s2.charAt(i)) {
//                if(s1.equals(s2.substring(i, i + l))) {
//                    return true;
//                }
//            }

            if (s2.substring(i, i + l).equals(s1)) {  // O(n) TC for this  length of substring.
                return true;
            }

        }

        return false;
    }


    public static void main(String[] args){

        String s1 = "kunal";
        String s2 = "Raju kunal ramu";

        Karp obj = new Karp();


//       // Call match method using the object
//        boolean found = obj.match(s1, s2);
//
//        System.out.println("String exists: " + found);

        System.out.println(obj.match(s1 , s2));

    }
}



//Your code contains multiple errors. Below are the issues and how to fix them:
//
//Errors in Your Code:
//Class Name Capitalization:
//
//Java is case-sensitive. Your class is named Karp, but in main, you instantiated it as karp obj = new karp();.
//karp should be Karp.
//Calling match Method Incorrectly:
//
//The method match is static, so you don’t need to create an object of Karp to call it. Instead, call it using Karp.match(s1, s2);.
//Incorrect Method Call Syntax:
//
//In obj.match(String s1 , String s2);, you passed parameter types instead of actual variables. It should be obj.match(s1, s2);.
//Out of Bounds Exception in Substring:
//
//When checking s2.substring(i, i + l), i + l may go out of bounds, causing a StringIndexOutOfBoundsException.
//Fix: Ensure i + l <= s2.length() before calling substring.
//Logic Issue in the for Loop:
//
//        s1.charAt(i) == s2.charAt(i) is incorrect because i is iterating over s2, not s1. Instead, directly compare the substring.
//Fixed Code:
//java
//        Copy
//Edit
//public class Karp {
//
//    // Method to check if s1 exists in s2
//    static boolean match(String s1, String s2) {
//        int l = s1.length();
//        int n = s2.length();
//
//        for (int i = 0; i <= n - l; i++) {  // Ensure substring is within bounds
//            if (s2.substring(i, i + l).equals(s1)) {
//                return true;
//            }
//        }
//
//        return false;
//    }
//
//    public static void main(String[] args) {
//        String s1 = "kunal";
//        String s2 = "Raju kunal ramu";
//
//        // Call the static method directly
//        boolean found = Karp.match(s1, s2);
//
//        System.out.println("String exists: " + found);
//    }
//}


//Fixes and Explanations:
//        ✅ Correct method call: Karp.match(s1, s2); (no need for an object).
//        ✅ Prevents out-of-bounds error: i <= n - l ensures substring fits within s2.
//        ✅ Fixed logic: Directly compare s2.substring(i, i + l) with s1.
//        ✅ Proper casing: Karp obj = new Karp(); instead of karp obj = new karp();.
//
//Expected Output:
//arduino
//        Copy
//Edit
//String exists: true
//Let me know if you have any questions! 🚀
//
//
//
//
//
//
//
//You said:
//        if I removed static then I need to create an object and neeed o call it right for match method ? - IMPORTANT
//ChatGPT said:
//Yes, if you remove static from the match method, you must create an object of the Karp class before calling it.
//
//Updated Code (Without static)
//java
//        Copy
//Edit
//public class Karp {
//
//    // Instance method (without static)
//    boolean match(String s1, String s2) {
//        int l = s1.length();
//        int n = s2.length();
//
//        for (int i = 0; i <= n - l; i++) { // Ensure substring is within bounds
//            if (s2.substring(i, i + l).equals(s1)) {
//                return true;
//            }
//        }
//
//        return false;
//    }
//
//    public static void main(String[] args) {
//        String s1 = "kunal";
//        String s2 = "Raju kunal ramu";
//
//        // Create an object of Karp
//        Karp obj = new Karp();
//
//        // Call match method using the object
//        boolean found = obj.match(s1, s2);
//
//        System.out.println("String exists: " + found);
//    }
//}
//Key Changes & Explanation:
//        ✅ Removed static from match method
//✅ Created an object: Karp obj = new Karp();
//✅ Called method using the object: obj.match(s1, s2);
//
//Output (Expected)
//arduino
//        Copy
//Edit
//String exists: true
//Let me know if you have any doubts! 🚀