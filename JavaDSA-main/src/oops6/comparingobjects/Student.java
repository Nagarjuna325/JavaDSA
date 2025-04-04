package oops6.comparingobjects;

public class Student implements Comparable<Student>{
    int rollno;
    float marks;

    public Student(int rollno, float marks) {
        this.rollno = rollno;
        this.marks = marks;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return marks + "";
    }

    @Override
    public int compareTo(Student o) {
        System.out.println("in compareto method");
        int diff = (int)(this.marks - o.marks);  // o - old marks.

        // if diff == 0: means both are equal
        // if diff < 0: means "o" is bigger else o is smaller

        return diff;
    }
}


// we can compare objects using the "COMPARABLE" interface in java.
// we can also have a interface with generic types.
// "compareTo" method from "comparabl" interface.


//  String obj1 = "Sai";  HashCode1 = 1234;
//  String obj2 = "Sai";  obj2 = HashCode1;
//  String obj3 = new String("Sai");  HashCode2 = 121333;

// == True , .equal()

// ==  False - reference compares(HashCode) , .equalsTo() - True
//



// Obj

// class Human{
//   String Name;
 //  int id;

// }

// Human h1 = new Human("sai", 1);  hashcode1 = 1234
// Human h2 = new Human("sai", 1);  hashcode2 = 3271

// h1 == h2