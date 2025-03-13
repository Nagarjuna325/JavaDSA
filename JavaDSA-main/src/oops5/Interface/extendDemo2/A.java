package oops5.Interface.extendDemo2;

public interface A {
    default void fun(){
        System.out.println("I am in A");
    }  // the main intent in adding this
    // is as we override it we will get an error again it breaks main purpose for which interface is created.
    // So then why it is introduced?
    // because if we want to expand an interface means if we add a method to an interface we know that we need to provide
    // implementation of that method to all the classes which implements that interface which will be an hectic process.
    // so thats why the default methods is introduced in interface from JAVA 8.


    // static interface methods should always have a body. - static methods in interface should always have a methods body.
    static void greeting() {
        System.out.println("Hey I am static method");
    }
}
