package oops5.abstract1;

public class abst {
}


// an abstract clas is a class which has only method defination and not the body of the method
// body of the method is implimented by child class.

// So now we can achieve the "MULTIPLE INHERITANCE" using abstract class. But how?
// because it removed the confusion if a single class inherits from a multiple class( same like having a 2 fathers or mothers)
// if the two superclass has a same method then when using in subclass it will go to confusion to which one to use.
// That why. as abstract class doesnt have implemetaion only subclass will need to implement so there is no confusion.
// but still we cannot achieve multiple inheritance -
// public class Son extends Parents , Parents2 - no we cannot still with abstraction for this we will use interface.
//1️⃣ Understanding Abstract Classes
//An abstract class:
//
//Can have abstract methods (method signature without implementation).
//
//Can also have concrete methods (methods with implementation).
//
//Cannot be instantiated directly.

// if a class contains one or more methods then a class needs to be declared as a abstract class.
// every child class must override all the methods of parent class.


// can we have a variables in a abstract class? - yes

// can we create an "OBJECT" to a abstract class? - no WHY? because the abstract needs an implemetation  then if u create an object of abstract what is the use.
// can we create an "abstract constructor" ? - NO

// can we create an "abstract static methods" ? - NO

// can we create a "static methods" in a abstract class? -YES

// can abstract methods can have a normal methods? -YES

// can we have a final abstract class? - NO