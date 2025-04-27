package oops2.staticexample;

public class Main {
    public static void main(String[] args) {
//        Human kunal = new Human(22, "Kunal", 10000, false);
//        Human rahul = new Human(34, "Rahul", 15000, true);
//        Human arpit = new Human(34, "arpit", 15000, true);

        // System.out.println(kuna.name);
//
        // what if there were some property which common to every object ? - Like Population.
        // So the "Property" which does not belong to a an object and is common for every object, it is called as static variables.

         // System.out.println(kuna.population); // when population is not declared as static it will give us 1
        // System.out.println(kuna.population); 1 , but when we declare it as static it will give us 2, which is correct.

//        System.out.println(Human.population); - if we use non static o/p will be 1 if we use kunal.population and rahul.population
//        System.out.println(Human.population);
//        System.out.println(Human.population);

        Main funn = new Main(); //
        funn.fun2();

    }

    // this is not dependent on objects
    static void fun() {
//        greeting(); // you cant use this because it requires an instance or simply non static method inside the static method.
        // but the function in which you are using it or calling it in, does not depend on "instances or objects"

        // imp - // you cannot access non static stuff without referencing their instances in
        // a static context

        // hey greetings where is ur object?

        // if it a non static we require a object to access it.

        // hence, here I am referencing it
        Main obj = new Main();  // Main is the class
        obj.greeting();
        // Now it works we created an object to reference, non-static stuff and we can now run it inside the static members.
    }


    // but if see here it is a non-static method inside it we are calling a non -static method without creating an object to greetings
    // how it works?
    // because the object is created for fun2 by the main method as everthing goes inside the static main method
    // so object is created there. by sure for the fun2() method which is used by greeting() inside.

    // simple story remeber a guest entered ur room and asking will u run me
    // hey bro i need a object fun2 will tell it will be created for me,  i will take u with me
    void fun2() {

        greeting();
    }

    // we know that something which is not static, belongs to an object
    void greeting() {
        // we can have a static member inside a non static member.? -Yes
//        fun();
        System.out.println("Hello world");
    }
}
