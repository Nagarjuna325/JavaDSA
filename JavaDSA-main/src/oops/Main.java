
package oops;

public class   Main {
    public static void main(String[] args) {
        // store 5 roll nos
        int[] numbers = new int[5];

        // store 5 names
        String[] names = new String[5];

        // Now teacher asks u to create a Student data Structure which  stores ,{rollno, name, marks.}
        // but the way u created below is different  data structures to store each one type
        // but ur teacher wants some sort of data structure where every single element is a student which needs to contain all this 3 details
        // same like in the above where every "names"(object) is a String type.
        // data of 5 students: {roll no, name, marks}
        int[] rno = new int[5];
        String[] name = new String[5];
        float[] marks = new float[5];

        Student[] students = new Student[5]; // every single element in students array contains all the 3 items

        // if we want to create our own datatype we use classes.-

        // just declaring
//        Student kunal;  //
        // kunal is now in stack memory which is a reference variable and to what it is pointing now?
        // it points to "NULL" - So for objects it is null, and for primitives it may be different?
         // System.out.println(kunal.rno); gives us a error like variable 'kunal' might not have been intiliazed.

//        kunal = new Student();  // for actuall objects creation we use "NEW" keyword.
          // dynamically allocates memory and returns the reference is returned to "kunal"

        // in the below all the code at left side happens at compile time and all the things at
        // right side will happen at run-time or dynamic memory allocation.

        // System.out.println(kunal); // what is the value Student@1324(some hashvalue)

        Student kunal = new Student(15, "Kunal Kushwaha", 85.4f);
        Student rahul = new Student(18, "Rahul Rana", 90.3f);

//        kunal.rno = 13;
//        kunal.name = "Kunal Kushwaha";
//        kunal.marks = 88.5f;


//        kunal.changeName("Shoe lover");

//        kunal.greeting();  // what is the output is - Hello My name is Kunal Kushwava

//
        System.out.println(kunal.rno);
        System.out.println(kunal.name);
        System.out.println(kunal.marks);
        // kunal.salary; // gives us error because it is a static type language.


        // object that takes other object as a argument
        Student random = new Student(kunal);
        System.out.println(random.name);


        // caling a constructor from another constructor
        Student random2 = new Student();
        System.out.println(random2.name);

        Student one = new Student();
        Student two = one;


        // if make a change through one reference variable then the value for the second reference
        // variable also changes as both are pointing to the same object.
        one.name = "Something something";

        System.out.println(two.name);

    }
}

// create a class
// this is a datatype for every single student
// for every single student
class Student {  // class is a template for creating objects (by using car template(engine, price, seats) - different
    // objects we created maruti , Ferrari, Audi - but the properties are different for each car.
    // class is a set of rules in real-world , it does not exist physically.
    int rno;
    String name;
    float marks = 90;

    // we need a way to add the values of the above
    // properties object by object

    // we need one word to access every object we create

    //    Student(){
//        kunal.rno = 13; // we need a particular way to replace kunal space with that type of object we created.
       // when I say Student rahul , i want automatically rahul at the kunal space.
      // the way to access the reference variable of the object that way is using "THIS" keyword.
//        kunal.name = "kunal";
//        kunal.marks = 80;
//    }

//    Student(){
//        this.rno = 13;
//        this.name = "kunal";
//        this.marks = 80;
//    }

    void greeting() {
        System.out.println("Hello! My name is " + this.name); // internally it will,be like this.name is replaced with kunal.name - replaces with the refernce varaible
        // in simple terms
    }

    void changeName(String name) {

        this.name = name;
    }


    // creating a constructor that takes names from other object
    Student  (Student other) {
        this.name = other.name;  // other is replaced with kunal and this.name with random
        // random.name = kunal ;
        this.rno = other.rno;
        this.marks = other.marks;   // at line 59 , 60.
         // so simple this means which object we are refering to0, or current object
    }

    Student () {  // for the line random2 - object
        // this is how you call a constructor from another constructor
        // internally: new Student (13, "default person", 100.0f); is replaced at new Student() place in random2;
        // creating a new object at the call
        this (13, "default person", 100.0f); // it refers to the below constructor
    }


    // Student arpit = new Student(17, "Arpit", 89.7f);
    // here, this will be replaced with arpit
    Student (int rno, String name, float marks) {
        this.rno = rno;
        this.name = name;
        this.marks = marks;
    }

    // constructors doesnt have retrurn because class type is the return type by default.

    // other way

//    Student (int roll, String naam, float merks) {
//        rno = roll;
//        name = naam;
//        marks = merks;  // if use different names in argumnets it will works without using this.rno but if we have like
          // same names in the arguments and inside it like int rno and inside also like rno = rno - then it wont work
    
//    }
}



// why does we dont use new keyword for creating a primitive datatype?
// becuase in java primitives dt are not objects they are stored in stack memory that why java is fast compared to python
//