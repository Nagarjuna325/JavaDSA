package oops2.staticexample;

public class Innerclass3 {
    static class Test {  // Inner class - class inside another class
        String name;  // Internally everything will be static.

        public Test(String name){
            this.name = name;
        }

    }

    public static void main(String[] args){

        Test a = new Test("kunal");
        Test b = new Test("Rahul");

        System.out.println(a.name);
        System.out.println(b.name);
    }
}

// what is the output now?
// Kunal
// Rahul
// How? As we know static means does not depends on object then how does this 2 objects has unique identity here?
// Because static means where it is mentioned in which context - in the above static near the class means the class
// does not depend on the objects of the Outer class(Innerclass3) , but it can have its own instance of the object.(individual identity).

// One more point only nested classes will be static. - IMP

// Static methods and variables are resolved at compile time. why?
//