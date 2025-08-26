package recur;

public class Lettercombinations {
    public static void main(String[] args){

        phone("", "12");

    }

    static void phone(String p, String up){

        if(up.isEmpty()){

            System.out.println(p);
            return;
        }

      int digit =  up.charAt(0) - '0'; // this will convert '2' which is a char now into 2  which is a integer

        for( int i = (digit -1)*3; i < digit * 3; i++){

            char ch = (char)('a' + i);

            phone( p + ch, up.substring(1));
        }
    }
}


//    In the expression int digit = up.charAt(0) - '0';, although you're subtracting two characters, the result is actually an integer. Here's why:
//
//        up.charAt(0) returns the character at the 0th position of the string up. Let's say the character is '5', which is a character representation of the digit 5, not the integer 5.
//
//        '0' is also a character, with an ASCII (or Unicode) value of 48. All digits '0' through '9' are sequentially represented in ASCII, so:
//
//        '0' has an ASCII value of 48,
//        '1' has an ASCII value of 49,
//        '2' has an ASCII value of 50,
//        and so on, up to '9' (which has an ASCII value of 57).
//        When you subtract '0' from another character that represents a digit (like '5'), you are subtracting their ASCII values. For example:
//
//        java
//        Copy code
//        '5' - '0' = 53 - 48 = 5
//        So, this subtraction gives you the integer representation of the digit (in this case, 5), not the character. That's why int digit = up.charAt(0) - '0'; converts the character '5' into the integer 5.
//
//        In summary:
//
//        You are subtracting two characters based on their ASCII values.
//        This subtraction results in an integer, which corresponds to the numeric value of the digit.
