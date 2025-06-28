package dailyleetcode;

public class Binary {

    public static void main(String[] args) {

        String a = "10";
        String b = "11" ;

        System.out.println( addBinary(a , b));
    }


    public static String addBinary(String a, String b) {

        StringBuilder result = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while( i >= 0 || j >= 0 || carry == 1){

            int digitA = ( i >= 0) ? a.charAt(i) - '0' : 0 ;
            int digitB  = ( j >= 0) ? b.charAt(j) - '0' : 0 ;

            int sum = digitA + digitB + carry;

            result.append(sum % 2); // modulus give us the remainder and division gives the quotient

            carry = sum / 2;

            i-- ;
            j-- ;
        }

        return result.reverse().toString();
    }

}
