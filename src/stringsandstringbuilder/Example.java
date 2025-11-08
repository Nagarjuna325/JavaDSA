package stringsandstringbuilder;

public class Example {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 4, 19};
        int num = 10;
        String name = "Kunal Kushwaha";
//        System.out.println(name);

        String a = "Kunal";
        System.out.println(a);
        a = "Kushwaha"; // how it is changed?
        System.out.println(a);
    }
    // Strings are immutable in Java for security reason
}
