package oops5.abstract1;

public abstract class  Parent {
    int age;  // can we have a variables instance in abstract class? - Yes.
    final int VALUE;

    public Parent(int age) {  // we can create constructors to an abstract class.

        // but we cannot create abstract constructor - like abstract public Parent(){} - like this.
        this.age = age;
        VALUE = 32456789;
    }

    static void hello(){
        System.out.println("hey");
    }

    void normal() {
        System.out.println("this is a normal method");
    }

    abstract void career();
    abstract void partner();
}
