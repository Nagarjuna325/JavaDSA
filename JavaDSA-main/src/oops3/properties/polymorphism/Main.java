package oops3.properties.polymorphism;

public class Main {
    public static void main(String[] args) {
        Shapes shape = new Shapes();
        Shapes circle = new Circle();
        Shapes square = new Square();

        circle.area();
    }

}


//NOTE:

//Shapes shape = new Shapes();
//Shapes circle = new Circle();
//Shapes square = new Square();

// if the type of refernce variable is Parent class and the type of object is of subclass then the
// which method will be called depends on the type of child(it is called "upcasting" or simpely "overriding" ) - but the twist is as we know we learnt that
// the variables or methods an  object can as access depends on the refernce type not on the object type
// but here also refernce type is only deciding but the child class is overridding the parent class method. so it will run child class
// method if both parent and child have a same method, but if the parent class does not have the child method which we are
// accessing , it will give us error and we cannot acces the child one , so the parent class also must have it.

// OBJECT TYPE DEFINES WHICH ONE TO RUN , REFERENCE TYPE DEFINES WHICH ONE TO ACCESS.

// BUT HOW JAVA DETEMINES THIS?
// by using dynamic method dispatch - at runtime it determines , it is a mechanism by which a overriden method is determined at run time
// rather than compile time.

// we know that a super class refernce varaible can access the subclass variables.

// A superclass reference can still invoke overridden methods of the subclass due to polymorphism,
// but it cannot access subclass-specific methods or fields directly.

//we know that a super class refernce varaible can access the subclass variables in
//        java how because we know that the super class will not have access to subclass methods or variables then how the refernce
//        varable will have accesss explain with simple example?

//        In Java, a superclass reference variable cannot directly access the subclass's specific variables or methods, even if the reference points to a subclass object. This is because the reference type determines what members can be accessed, not the object's runtime type.
//
//        However, if the subclass overrides a method in the superclass or exposes subclass-specific functionality via methods defined in the superclass (e.g., by overriding or using polymorphism), then a superclass reference can invoke those methods.
//
//Example to Demonstrate
//        java
//Copy
//        Edit
//class SuperClass {
//    public void display() {
//        System.out.println("Method in SuperClass");
//    }
//}
//
//class SubClass extends SuperClass {
//    // Subclass-specific variable
//    public int subVar = 10;
//
//    // Subclass-specific method
//    public void show() {
//        System.out.println("Method in SubClass");
//    }
//
//    // Overriding superclass method
//    @Override
//    public void display() {
//        System.out.println("Overridden method in SubClass");
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        // Superclass reference pointing to SubClass object
//        SuperClass ref = new SubClass();
//
//        // Accessing overridden method
//        ref.display(); // Calls the overridden method in SubClass
//
//        // Attempting to access subclass-specific members
//        // ref.subVar; // ERROR: Cannot resolve symbol 'subVar'
//        // ref.show(); // ERROR: Cannot resolve method 'show'
//
//        // Correct way: Casting to SubClass
//        SubClass subRef = (SubClass) ref;
//        System.out.println("Accessing subVar: " + subRef.subVar); // Works
//        subRef.show(); // Works
//    }
//}
//Output
//        sql
//Copy
//        Edit
//Overridden method in SubClass
//Accessing subVar: 10
//Method in SubClass
//Key Points
//Superclass Reference:
//
//It can access only the methods and variables declared in the superclass.
//If a method is overridden in the subclass, the runtime type (subclass) determines which method gets executed (polymorphism).
//Subclass-Specific Members:
//
//To access subclass-specific variables or methods, you must cast the reference to the subclass type.
//Polymorphism:
//
//A superclass reference can still invoke overridden methods of the subclass due to polymorphism, but it cannot access subclass-specific methods or fields directly.
//




//what about in python
//ChatGPT said:
//ChatGPT
//        In Python, the behavior is different from Java because Python is dynamically typed. This means that attributes and methods are resolved at runtime, regardless of the type of the reference variable. Therefore:
//
//A superclass reference (or a reference to an instance of the superclass) can access subclass-specific variables and methods if the object is an instance of the subclass.
//However, if an attribute or method is not defined in the superclass but exists only in the subclass, attempting to access it on an object of the superclass will raise an AttributeError.
//Example in Python
//        python
//Copy
//        Edit
//class SuperClass:
//def display(self):
//print("Method in SuperClass")
//
//class SubClass(SuperClass):
//def __init__(self):
//self.sub_var = 10  # Subclass-specific variable
//
//def show(self):
//print("Method in SubClass")
//
//    # Overriding the superclass method
//def display(self):
//print("Overridden method in SubClass")
//
//# Superclass reference pointing to a SubClass object
//        ref = SubClass()
//
//# Accessing methods and variables
//ref.display()  # Calls the overridden method in SubClass
//print("Subclass variable:", ref.sub_var)  # Accesses subclass variable
//ref.show()  # Calls the subclass-specific method
//
//# Superclass instance
//super_ref = SuperClass()
//super_ref.display()  # Calls the method in SuperClass
//# super_ref.sub_var  # ERROR: AttributeError, as `sub_var` is not in SuperClass
//# super_ref.show()  # ERROR: AttributeError, as `show` is not in SuperClass
//Output
//        kotlin
//Copy
//        Edit
//Overridden method in SubClass
//Subclass variable: 10
//Method in SubClass
//Method in SuperClass
//Key Points in Python
//Dynamic Typing:
//
//Python resolves attributes and methods at runtime, so you can access subclass-specific variables and methods from a superclass reference if the reference points to a subclass object.
//        Overriding:
//
//If a subclass overrides a method, calling that method on an instance of the subclass (even if the reference is of the superclass type) will invoke the subclass version.
//AttributeError:
//
//Attempting to access a variable or method not defined in the current class or its ancestors will raise an AttributeError. For example, a SuperClass instance cannot access sub_var or show.
//Flexible Nature of Python:
//
//You don't need explicit casting like in Java to access subclass-specific members. You only need to ensure the reference points to a subclass object.
//


















