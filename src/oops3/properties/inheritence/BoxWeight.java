package oops3.properties.inheritence;

// Time Stamp - 18:00

import java.util.ArrayList;

// child class
public class BoxWeight  extends Box {
    double weight;

    public BoxWeight() {  // creating a constructor

        this.weight = -1;
    }

    //    @Override
    static void greeting() {
        System.out.println("Hey, I am in BoxWeight class. Greetings!");
        ArrayList list = new ArrayList();
    }

    BoxWeight (BoxWeight other) {
        super(other); // so will call the Box constructor which has a single argument Box(Box old) this one
        // what we access depends on the reference variable type, not on the object type

        // super will call the constuctor just above its , immediate parent.
        weight = other.weight;
    }

    BoxWeight(double side, double weight) {
        super(side);
        this.weight = weight;
    }

    public BoxWeight(double l, double h, double w, double weight) {
        // use case 1 of super class
        // 1. used to initialise values present in parent class or simply calling parent class constructor to intilize it in child class.
        super(l, h, w); // what is this? calls the parent class constructor
//        System.out.println(super.weight);
        // super means directly above it.
        // 2.2nd use case of super keyword
         // super.h as this.h same

        // so suppose u have a same variable named weight in both subclass(child) and also in parent class
        // if u want to access the super class variable we can use
        // super.weight ; which refers to parent class

        // if we dont have a super method to initialize the method it will call the default constructor

        // 1. But the subclass cannot able to access the members of the super class which are declared as a "private" - IMP
        this.weight = weight;
        // super.weight = weight; we can also use it like if parent also has weight and we want weight we use like this. but now as Box - parent class also as weight variable it refers to parent one now.

        // if we use the above super(l,h,w); after the this.weight = weight; line we get error why?
        // Because child class cares about parent so we need to first declare those using constructor.
    }
}

