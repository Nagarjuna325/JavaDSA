package oops2.staticexample;

import static oops2.staticexample.StaticInt.a;

public class Innerclass1 {

     static class Test {  // Inner class - class inside another class
        String name;

        public Test(String name){
            this.name = name;
        }

    }

    public static void main(String[] args){

        Test a = new Test("kunal");  // getting an error to solve it check 3 innercode
        // java: non-static variable this cannot be referenced from a static context
        Test b = new Test("Rahul");

        System.out.println(a.name);
        System.out.println(b.name);
    }

}


// In the above if we observe carefully if we remove the static(keyword) beside the Test class we will get an error at line 16 & 17
// saying we cannot access the class(which is non-static) from a static member ,