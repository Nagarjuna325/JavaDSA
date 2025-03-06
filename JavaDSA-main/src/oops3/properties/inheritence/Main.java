package oops3.properties.inheritence;

public class Main {
    public static void main(String[] args) {
        Box box1 = new Box(4.6, 7.9, 9.9);
        box1.getL();
        Box box2 = new Box(box1);
//        System.out.println(box1.w + " " + box1.h);

        // SSo what is determing us not to access the child class variables and properties if we create a object to the
        // Parent class? Let check it now?

//        BoxWeight box3 = new BoxWeight();
//        BoxWeight box4 = new BoxWeight(2, 3, 4, 8);
//        System.out.println(box3.h + " " + box3.weight);



        // very important point

        // A Superclass Variable Can Reference a Subclass Object:
        //It is important to understand that it is the type of the reference variable—not the type of the object that it refers
        //to—that or determines what members can be accessed.

        // why about reverse?


//        Box box5 = new BoxWeight(2, 3, 4, 8);
//        System.out.println(box5.w + box5.weight);//here we will get error for box3.weight? why
//        // the reference variable type determines the which variable we have access to not the object type.

        // there are many variables in both parent and child classes
        // you are given access to variables that are in the ref type i.e. BoxWeight
        // hence, you should have access to weight variable
        // this also means, that the ones you are trying to access should be initialised
        // but here, when the obj itself is of type parent class, how will you call the constructor of child class to intilize it
        // this is why error
//        BoxWeight box6 = new Box(2, 3, 4); - that why it does not work
//        System.out.println(box6);

//        Box.greeting();


        BoxWeight box = new BoxWeight();
        BoxWeight.greeting(); // you can inherit but you cannot override
    }
}
