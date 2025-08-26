package HashMap;

import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        // String name = "Rahul";

        // Integer a = 4235678;

        // int code = a.hashCode();

        // System.out.println(code);
    }
    public static void hashDemo() {
        // String name = "Rahul";

        // Integer a = 4235678;

        // int code = a.hashCode();

        // System.out.println(code);

        HashMap<String, Integer> map = new HashMap<>();

        map.put("Kunal", 89);
        map.put("Karan", 99);
        map.put("Rahul", 94);

        // System.out.println(map.get("Karan"));
        // System.out.println(map.getOrDefault("Apoorv", 78));
        System.out.println(map.containsKey("Karan"));

        HashSet<Integer> set = new HashSet<>();
        set.add(56);
        set.add(9);
        set.add(12);
        set.add(43);
        set.add(56);
        set.add(2);

        System.out.println(set);
    }

}


// hashcode of a number is number itself why because every number is a unuie one hashcode is just a unique number

// how we get in constant time using hashmap- due to hashcode it generates using a formula for a each value.
// hashing means we get a hashcode for the obj , but the number may be large so we will bring down to a small range value by dividing taking remeber.

//
