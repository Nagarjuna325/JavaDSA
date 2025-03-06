package oops3.properties.inheritence;


import java.util.ArrayList;

// child class
public class BoxWeight  extends Box {
    double weight;

    public BoxWeight() {
        this.weight = -1;
    }

    //    @Override
    static void greeting() {
        System.out.println("Hey, I am in BoxWeight class. Greetings!");
        ArrayList list = new ArrayList();
    }

    BoxWeight (BoxWeight other) {
        super(other); // so will call the Box constructor which has a single argument Box(Box old) this one
        // what we access depends on the reference variable not on the object type

        // super will call the constuctor just above its , immediate parent.
        weight = other.weight;
    }

    BoxWeight(double side, double weight) {
        super(side);
        this.weight = weight;
    }

    public BoxWeight(double l, double h, double w, double weight) {
        // use case 1 of super class
        // used to initialise values present in parent class
        super(l, h, w); // what is this? call the parent class constructor
//        System.out.println(super.weight);
        // super means directly above it.
        // 2nd use case of super keyword
         // super.h as this.h same

        // so suppose u have a same variable named weight in both subclass(child) and also in parent class
        // if u want to access the super class variable we can use
        // super.weight ; which refers to parent class

        // if we dont have a super method to initialize the method it will call the default constructor
        this.weight = weight;
    }
}
