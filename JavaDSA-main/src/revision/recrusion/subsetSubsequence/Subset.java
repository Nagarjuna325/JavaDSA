package revision.recrusion.subsetSubsequence;

public class Subset {

    // So the problem I have is given a String s ="baccad" and We need to get a ans ="bccd"
    // so without the a character in the String, So the first methiod O got spilt the string and store the character in a Array and
    // then fpor that charcyer array we create a new String by using the String Builder class in java and when we see a char we will skip it and contine still the last character of the array

    public static void main(String[] args) {
        String s = "abcdeappledafsf";
        char ch = 'a';

//        String result = removeCharacter(s, ch);
//        System.out.println("Result: " + result);  // Output: bccd
//
//        skip("", "baccde");
//        String ans=skip1("baccde");
//        System.out.println(ans);

        substring("",s);

        // 6th method

        String input = "bcappledapplee";
        StringBuilder result = new StringBuilder();
        removeSubstring(input, 0, result);
        System.out.println("Result: " + result.toString());  // Output: bcde
    }

    public static String removeCharacter(String s, char ch) {
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c != ch) {
                result.append(c);
            }
        }

        return result.toString();
    }

    // One line Solution
//    So for strings, both of these will do the same thing:
//    s.replace("a", "");
//    s.replaceAll("a", "");

    // using the the other method recursion way

    static void skip(String p, String up){

        if( up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        if( ch == 'a'){
            skip(p, up.substring(1)); // so the substring is creating a object by removing the first character if it is abbcd , then substring
            // bccd is created a new object
        }else{
               skip( p+ch, up.substring(1));
        }
    }

    // one more way just using the 1 argument
    static String skip1(String up){

        if( up.isEmpty()){
            return "";
        }

        char ch = up.charAt(0);

        if( ch == 'a'){
            return skip1(up.substring(1));
        }else{
            return ch+skip1(up.substring(1));
        }
    }


    // 4th question what if we want to skip a substring entirely like "apple" from a large string like
    // "abcdeappledafsf"



    static void substring(String ans, String up){

        if(up.isEmpty()){
            System.out.println(ans);
            return;
        }


        char  ch = up.charAt(0);
        if( up.startsWith("apple")){
            substring(ans, up.substring(5));
        }else{
            substring( ans + ch, up.substring(1));
        }
    }

    // other way without creating new objects everytime optimized one

    static void removeSubstring(String s, int index, StringBuilder ans) {
        if (index >= s.length()) {
            return;
        }

        if (index + 5 <= s.length() && s.startsWith("apple",index)) {
            removeSubstring(s, index + 5, ans); // Skip "apple"
        } else {
            ans.append(s.charAt(index));
            removeSubstring(s, index + 1, ans);
        }
    }

    //You're very close, but there's one small mistake in this line:
    //
    //java
    //Copy
    //Edit
    //if (index + 5 <= s.length() && s.startsWith("apple"))
    //❌ What's the issue?
    //You're not using the index in the startsWith() call. So this line:
    //
    //java
    //Copy
    //Edit
    //s.startsWith("apple")
    //will always check only from the beginning of the string, i.e., index 0.
    //
    //But since you're recursively checking different positions (using index), you need to check whether "apple" starts at that position, not at the start of the string.

//    ✅ Summary:
//    Code	Checks from
//    s.startsWith("apple")	           Always index 0
//    s.startsWith("apple", index)	  From current index ✅
//
//    So yes, you're almost right — just pass index to startsWith() to make it fully correct.
//
//    Let me know if you want to extend this to remove more than one word or make it case-insensitive!
}
