package oops3.properties.inheritence;

public class Main {
    public static void main(String[] args) {
        Box box1 = new Box(4.6, 7.9, 9.9);
        box1.getL();
        Box box2 = new Box(box1);  // which constructor we have which takes another constructor , yes we have one declared
//        System.out.println(box1.w + " " + box1.h);


//        BoxWeight box3 = new BoxWeight();
//        System.out.println(box3.h + " " + box3.weight);
        // output prints those values : -1.0  -1.0

        //        BoxWeight box4 = new BoxWeight(2, 3, 4, 8);




        // very important point

        // SSo what is determing us not to access the child class variables and properties if we create a object to the
        // Parent class? Let check it now?

        // A Superclass Variable Can Reference a Subclass Object:
        //It is important to understand that it is the type of the reference variable—not the type of the object that it refers
        //to—that or determines what members can be accessed.

        // why about reverse?


//        Box box5 = new BoxWeight(2, 3, 4, 8); // here the object is of type, BoxWeight type so it has access to its parent constructor
        // that's why we are able to assign 4 values.

//        System.out.println(box5.w + box5.weight);//here we will get error for "box3.weight?" why
//        // the reference variable type determines the which variable we have access to not the object type.

         // why the below error code line is getting

        // there are many variables in both parent and child classes
        // you are given access to variables that are in the ref type i.e. BoxWeight
        // hence, you should have access to weight variable
        // this also means, that the ones you are trying to access should be initialised
        // but here, when the obj itself is of type parent class, how will you call the constructor of child class to intilize it
        // this is why error , hence u cannot reference and have 4 value (weight) of child so it gives u error.
//        BoxWeight box6 = new Box(2, 3, 4); - that why it does not work
//        System.out.println(box6);

//        Box.greeting();


        BoxWeight box = new BoxWeight();
        BoxWeight.greeting(); // you can inherit but you cannot override


        BoxPrice box6 = new BoxPrice();
    }
}


// Most confusing and important part in the entire Java at time stamp of - 36:00