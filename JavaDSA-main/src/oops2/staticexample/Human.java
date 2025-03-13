package oops2.staticexample;

public class Human {
    int age;
    String name; // instance variables or
    int salary;
    boolean married;
    static long population;  // static variables

    static void message() {
        System.out.println("Hello world");
//        System.out.println(this.age); // cant use this over here? Why?
    }

    // create a constructor
    public Human(int age, String name, int salary, boolean married) {
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.married = married;
        // this.popultion += 1; - it will be wrong(it will work) when we declare a variable as a static it is independent of object
        // so we need to use className as below but it will also give same output with the "this" also why?
        // because first it checks whether the variable is in instance of the object or not , As static belongs to class it will be
        // in the class not in object so it updates there.(for clear understanding see the pdf diagram).

        Human.population += 1; // we use className to access the static variables or class variables
    }
}


// what if there is a some sort of property that is common to every human being? like population
// it is not related to any object it is same for all the objects like we created rahul, varun - it will be same

// when accessing a static variable we can access it through className dont use reference variable(like kunal.population) it will
// work but a better way is to use ClassName( Human.population). why it will still works? because it when checking
// first it will check in object of the class if it not there then it will check in class.


// what is static defination - a "static" a variable which we can access it without even creating a object to a class.
// we can create both methods and variables as "static".

// why main is declared as a static method?
// main is the first thing which runs when we run the java code.
// static method variables they belong to the "class"  not to the "object".

// inside a static method we cannot use a method or a variable that is non-static. - check the code of greeting() method.
// a static method can only access a static methods it cannot access non static methods why? we know non-static methods belongs to
// a object.

// we can have a static member inside a non static member.

