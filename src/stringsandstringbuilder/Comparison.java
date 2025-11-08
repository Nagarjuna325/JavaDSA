package stringsandstringbuilder;

public class Comparison {

    public static void main(String[] args) {


        String a = "kunal";
        String b = "kunal";


        System.out.println( a == b); // output true

        // == is a comparator
        // == checks both values and reference type

        String a1 = new String("Kunal");
        String b1 = new String("Kunal");

        System.out.println( a1 == b1);

        System.out.println( a1.equals(b1));

        System.out.println( a1.charAt(0)); // so internally the Strings are stored as arrays only
    }
}
