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


//Explanation of the Code
//java
//        Copy
//Edit
//package oops2.staticexample;
//
//public class Innerclass3 {
//    static class Test {  // Static Inner Class
//        String name;
//
//        public Test(String name){
//            this.name = name;
//        }
//    }
//
//    public static void main(String[] args){
//        Test a = new Test("kunal");
//        Test b = new Test("Rahul");
//
//        System.out.println(a.name);
//        System.out.println(b.name);
//    }
//}
//Output
//        nginx
//Copy
//        Edit
//kunal
//        Rahul
//Why do the objects a and b have unique identities despite the class being static?
//Many people misunderstand static and assume that if a class is static, all its variables will also be static. That is not true. Let's break it down:
//
//        1️⃣ What does static mean when applied to a class?
//When we declare a nested class (Test) as static, it means that:
//
//The inner class does not depend on an instance of the outer class (Innerclass3).
//
//We can create instances of Test without needing an instance of Innerclass3.
//
//        2️⃣ Does static make instance variables (name) shared?
//No! A static inner class does not mean that its instance variables (non-static fields) are static.
//
//Each object of Test has its own separate copy of name.
//
//In the code:
//
//java
//        Copy
//Edit
//Test a = new Test("kunal");
//Test b = new Test("Rahul");
//a gets its own copy of name = "kunal"
//
//b gets its own copy of name = "Rahul"
//
//This is why the output prints different names.
//
//        3️⃣ When would variables be shared among all objects?
//If we had declared name as static:
//
//java
//        Copy
//Edit
//static class Test {
//    static String name;  // Shared across all instances
//    public Test(String name){
//        this.name = name;
//    }
//}
//Now, every object shares one copy of name, so the last assigned value ("Rahul") would override "kunal", and the output would be:
//
//nginx
//        Copy
//Edit
//        Rahul
//Rahul
//Why Are Static Methods and Variables Resolved at Compile Time?
//This is an important Java concept.
//
//        1️⃣ Static Members Belong to the Class, Not the Object
//Static variables and methods are stored in the "Method Area" of JVM memory, not in the heap where objects are stored.
//
//Since static members do not depend on an object, the Java compiler can resolve them during compile time.
//
//2️⃣ Example to Show Compile-Time Resolution
//java
//        Copy
//Edit
//class Example {
//    static int x = 10;
//
//    static void display() {
//        System.out.println("Static method");
//    }
//
//    public static void main(String[] args) {
//        System.out.println(Example.x); // Resolved at compile time
//        Example.display();  // Resolved at compile time
//    }
//}
//The Java compiler knows before execution that x and display() belong to Example, so it does not need an object to access them.
//
//Key Takeaways
//✔ Static Inner Class → Means the inner class does not depend on an outer class instance.
//        ✔ Instance Variables Are Not Static → Even in a static inner class, non-static variables belong to individual objects.
//✔ Static Members (Variables & Methods) Are Resolved at Compile Time → Because they belong to the class, not an object.
//✔ If a Variable Is Static, It’s Shared → If name was static, all objects would share the same value.
//
//Would you like me to provide a deeper memory breakdown for better understanding? 🚀