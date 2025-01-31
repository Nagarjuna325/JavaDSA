package oops5.Interface.extendDemo2;

public interface A {
    default void fun(){
        System.out.println("I am in A");
    }
    static void greeting() {
        System.out.println("Hey I am static method");
    }
}
