package oops3.properties.polymorphism;

public class Shapes {
    public void area(){  // late binding
        System.out.println("Area of Shapes");
    }
}


// EARLY binding :
// final void area(){
   // System.out.println("I am in shapes");
//}

// Uses cases of "FINAL" keyword.
// 1.To define a variable as fixed
// 2. To define a class with final keyword to prevent inheritance
// 3. To prevent method overriding in Polymorphism also.if a method is declared as final we cannot override it.advantages is
// ease of running- removing the method overhead at runtime. - "LATE BINDING" - run time ,
// "EARLY BINDING" - compile time.

// so if a class is declared as final , implicity it members are also final only.

// 1.Can we override a static method? - NO- can u also write a code to show.? Can u explain it why?
// 2.can we inherit a static method in child class? -yes
// 1. As we know static methods are avilable without an object to it, it will be avaiable to any class as we know anyway the main
// is called in the program as we know static methods or variables are avaibale to main method so every subclass can have access to it.
// there is no point in overriding the static methods in parent class, as we know form were every the object is created and called
// the static methods will run anyway as they belong to the class.
// EVENTHOUGH static methods are inherited . IMP VERY VERY.

// You can inherit but you cannot override.

// In simple "overriding" depends on "OBJECTS", but "static" does not depend on "objects" so it is not "overriden".

// THIS polymorphism or overriding, will not be applicable to instance variables?( instance variables which are class variables).