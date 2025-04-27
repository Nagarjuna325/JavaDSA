package oops5.Interface.extendDemo2;

public class Main implements B {
//    @Override
//    public void fun() {
//
//    } - find error why?

    @Override
    public void greet() {

    }
    public static void main(String[] args) {
        Main obj = new Main();
        A.greeting();
    }
}

// annotations is also an interface in java.