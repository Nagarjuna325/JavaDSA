package oops6.cloning;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Human kunal = new Human(12, "varun");
        Human twin = new Human(kunal); // see here we are copying the object to the object twin, but the problem is it takes lot of time.

        // so easy way to do is using clonable interface.


        Human twin2 = (Human)kunal.clone(); // so the same above thing is implemented using clone like this.

        twin2.arr[0] = 100;

        System.out.println(Arrays.toString(twin2.arr));
    }
}
