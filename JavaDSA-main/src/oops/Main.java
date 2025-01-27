
package oops;

public class Main {
    public static void main(String[] args) {
        // store 5 roll nos
        int[] numbers = new int[5];

        // store 5 names
        String[] names = new String[5];

        // data of 5 students: {roll no, name, marks}
        int[] rno = new int[5];
        String[] name = new String[5];
        float[] marks = new float[5];

        Student[] students = new Student[5];

        // just declaring
//        Student kunal;
//        kunal = new Student();

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
// for every single student
class Student {
    int rno;
    String name;
    float marks = 90;

    // we need a way to add the values of the above
    // properties object by object

    // we need one word to access every object

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
        this.rno = other.rno;
        this.marks = other.marks;
         // so simple this means which object we are refering to0, or current object
    }

    Student () {
        // this is how you call a constructor from another constructor
        // internally: new Student (13, "default person", 100.0f);
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
//        marks = merks;  // if use different names in argumnets it will work without using this.rno if have then we can do
//    }
}



// why does we dont use new keyword for creating a primitive datatype?
// becuase in java primitives dt are not objects they are stored in stack memory that why java is fast compared to python
//