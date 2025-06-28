package oops2.staticexample;

// this is a demo to show initialisation of static variables
public class StaticInt {
    static int a = 4;
    static int b;

    // will only run once, when the first obj is create i.e. when the class is loaded for the first time
    // static block runs only once
    static {
        System.out.println("I am in static block");
        b = a * 5;
    }


    // we can also have a public static void main inside a method non static method

    public static void main(String[] args) {

        // creating an object to above class
        // to access the non static methods inside a static block

        StaticInt obj = new StaticInt();
        System.out.println(StaticInt.a + " " + StaticInt.b);


        // observe accessing the variables of a non static class with className

        StaticInt.b += 3;

        System.out.println(StaticInt.a + " " + StaticInt.b);

        // when we created here other object also, but "I am in static block" run only once when a first object is created
        StaticInt obj2 = new StaticInt();
        System.out.println(StaticInt.a + " " + StaticInt.b); // what is the output now
        // 4, 23
        // second time we created the object right the static block does not run again it ran only once when the first
        // obj is created and class is loaded.- This is the main outcome we need to studied from the code.
    }
}
