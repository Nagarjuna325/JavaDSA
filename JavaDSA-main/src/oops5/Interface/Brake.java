package oops5.Interface;

public interface Brake {
    //void brake();
//    void start();
}


// a class can inherit more than one interface on the other a class can inherit only one super class.

// as we see the conflict is resolved in abstract class also but we cannot achieve multiple inheritence in abstract class.

// WE CAN IMPLEMENT A INTERFACE OF 2 DIFFERENT CLASSES IT DOESNT CARE WHETHER 2  classes OR RELATED OR NOT- "IMPORTANT"

//Q1.why does we cannot achieve mutiple inheritence with abstract , but why we can achieve with interface explain in a simple and easy way with in depth considering all the edge cases?
//
//
// In Java, multiple inheritance is not allowed with classes or abstract classes but is allowed with interfaces. Let’s break this down in a simple and clear way:
//
//Why Can't We Achieve Multiple Inheritance with Abstract Classes?
//Diamond Problem (Ambiguity):
//
//If two parent classes have a method with the same name, and a child class inherits from both, the compiler won't know which method to use. This leads to ambiguity.
//Example:
//java
//        Copy
//Edit
//abstract class A {
//    void display() {
//        System.out.println("Display from A");
//    }
//}
//
//abstract class B {
//    void display() {
//        System.out.println("Display from B");
//    }
//}
//
//class C extends A, B { // Not allowed
//    // Which display() method to use? Ambiguity!
//}
//State and Behavior:
//
//Abstract classes can have instance variables and concrete methods. If a child class inherits from multiple abstract classes, there could be conflicts in how these states and behaviors are inherited and initialized.
//Example:
//
//java
//        Copy
//Edit
//abstract class A {
//    int x = 10;
//}
//
//abstract class B {
//    int x = 20; // Conflict: Which x should the child inherit?
//}
//
//class C extends A, B { // Not allowed
//}
//Simplicity and Design:
//
//To avoid complexity and confusion, Java allows single inheritance for classes and abstract classes, ensuring a clear and straightforward hierarchy.
//Why Can We Achieve Multiple Inheritance with Interfaces?
//No State:
//
//Interfaces cannot have instance variables (before Java 8). They only have constants (final static variables), which don't cause conflicts like instance variables do.
//Default Methods (Post-Java 8):
//
//Starting from Java 8, interfaces can have default methods (methods with implementation). However, Java resolves conflicts between default methods to avoid ambiguity:
//
//If two interfaces have default methods with the same name, the implementing class must override the conflicting method.
//Example:
//
//java
//        Copy
//Edit
//interface A {
//    default void display() {
//        System.out.println("Display from A");
//    }
//}
//
//interface B {
//    default void display() {
//        System.out.println("Display from B");
//    }
//}
//
//class C implements A, B {
//    @Override
//    public void display() {
//        // Must resolve the conflict
//        System.out.println("Display from C");
//    }
//}
//Flexibility:
//
//Interfaces allow a class to inherit multiple behaviors without worrying about state or method conflicts.
//Design Choice:
//
//Interfaces are meant to define a contract (behavior) for classes to implement, while abstract classes provide partial implementation. This distinction allows multiple inheritance via interfaces to focus only on behavior.
//Edge Cases and Resolution
//1. Default Method Conflict
//When two interfaces have the same default method:
//
//The implementing class must override the method to resolve ambiguity.
//Example:
//
//java
//        Copy
//Edit
//interface A {
//    default void display() {
//        System.out.println("A's display");
//    }
//}
//
//interface B {
//    default void display() {
//        System.out.println("B's display");
//    }
//}
//
//class C implements A, B {
//    @Override
//    public void display() {
//        A.super.display(); // Explicitly call A's display
//    }
//}
//2. Static Methods in Interfaces
//Static methods in interfaces don’t participate in inheritance, so there’s no conflict. Example:
//
//java
//        Copy
//Edit
//interface A {
//    static void staticMethod() {
//        System.out.println("Static method from A");
//    }
//}
//
//interface B {
//    static void staticMethod() {
//        System.out.println("Static method from B");
//    }
//}
//
//class C implements A, B {
//    // No conflict, static methods are accessed via the interface name
//}
//Usage:
//
//java
//        Copy
//Edit
//A.staticMethod(); // Calls A's static method
//B.staticMethod(); // Calls B's static method
//Summary
//Feature	Abstract Classes	Interfaces
//Multiple Inheritance	Not allowed (to avoid ambiguity/conflicts).	Allowed (with conflict resolution).
//State (Instance Variables)	Can have state, leading to potential conflicts.	No state (constants only).
//Default Methods	Not available.	Supported (with conflict resolution).
//Static Methods	Supported.	Supported (no inheritance issues).
//Simple Analogy
//Abstract Classes: Like a parent. A child can have only one parent to avoid confusion about whose characteristics to inherit.
//        Interfaces: Like skills. A person can learn multiple skills (e.g., speaking, cooking), but if two teachers teach the same skill differently, the person decides how to use it (override).
//This design ensures flexibility (with interfaces) while avoiding complexity (with abstract classes).

//\

// PYTHON

//Python and JavaScript: Handling Multiple Inheritance
//Both Python and JavaScript handle multiple inheritance differently compared to Java. Let's examine how these languages approach this concept and the differences they bring.
//
//        1. Python: Multiple Inheritance is Allowed
//Python allows multiple inheritance directly, even for classes with implementations. It uses a mechanism called the Method Resolution Order (MRO) to resolve conflicts and determine the order in which classes are searched for attributes or methods.
//
//        Example:
//python
//        Copy
//Edit
//class A:
//def display(self):
//print("Display from A")
//
//class B:
//def display(self):
//print("Display from B")
//
//class C(A, B):  # Multiple Inheritance
//pass
//
//        obj = C()
//obj.display()  # Output: Display from A (MRO chooses A first)
//Key Features in Python:
//Method Resolution Order (MRO):
//
//Python uses the C3 Linearization algorithm to resolve the order of method lookups.
//The order can be checked with ClassName.__mro__.
//        Example:
//
//python
//        Copy
//Edit
//print(C.__mro__)
//# (<class '__main__.C'>, <class '__main__.A'>, <class '__main__.B'>, <class 'object'>)
//Avoiding Conflicts:
//
//If two parent classes define the same method, the MRO ensures that the method from the first specified parent is used.
//Developers can explicitly override methods in the child class to handle conflicts.
//Python's Flexibility:
//Python’s dynamic typing and duck typing allow seamless multiple inheritance without restrictions, but care must be taken to avoid complexity in deeply nested hierarchies.
//
