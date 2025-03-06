package oops;

public class Wrapper {
    public static void main(String[] args) {
//        int a = 10;
//        int b = 20;
//
//        Integer num = 45;

        Integer a = 10; // wrapper class // created as an object 'a' variable
        // what is a wrapper class?
        // converting a char or integer (primitives) to an object.
        Integer b = 20; // these are now reference variables to swap method
        // so it is like pass by reference value

        swap(a, b); // 1

        // but still it wont do swap in this why? actually reference value is passed then why?
        // beacuse in this case the Integer class is final class in java.

        System.out.println(a + " " + b);

//        final int bonus = 2;
//        bonus = 3; // It gives us error we cannot modify bonus.

        final A kunal = new A("Kunal Kushwaha");
        kunal.name = "other name"; // we change the value but see below we cannot reassign it.

        // when a non primitive is final, you cannot reassign it.

//        kunal = new A("new object"); - not allowed

        A obj = new A("Rnadvsjhv");

        System.out.println(obj);


        // as we know a reference variable cannot point to more than one object

//        for (int i = 0; i < 1000000000; i++) {
//            obj = new A("Random name");
//        }



        //        int a = 10;
        //        int b = 20;

        //       swap(a, b);// 2
        // output will swap why?

        // because in java it is pass by value only not reference for primitives datatypes


    }

    static void swap(Integer a, Integer b) { // 1 method
        Integer temp = a;
        a = b;
        b = temp;
    }


    static void swap(int a, int  b) { // 2   // this a and b here is just scope in this function only, not refer to int a = 10, b in class we declared
        // because in java there is no such thing as pass by reference , everything is pass by value only.(in primitives)
        // in objects of same but the reference value pass by reference value.

        int  temp = a;
        a = b;
        b = temp;
    }

}

class A {
    final int num = 10;
    String name;

    public A(String name) {
//        System.out.println("object created");
        this.name = name;
    }

    // when any object of the class is freed from the memory by garbage collector, this method is called and executed
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Object is destroyed");
    }
}


// what is final keyword?
// we cannot modify a value of the final variable.final variables must be intilized for sure. when it is declared.

// declaration with capital letters
// final int INCREASE = 10;
// final variables must be initlized always why declaring it.

// declaring a class as final is used to prevent inheritence.

// but when we declare a object as a final we cannot assign it to a new object but we can change the value of the object

// eg : final Student kunal = new Student();
//   kunal.name = "new name"; - it works

//  kunal = other object - does not work

// we cannot destroy a object by ourselves but we can tell what to do (to Garbage Collector) when object is destroyed automatically by garbage collector
// using the finalize keyword which statements to execute or actions to be done.