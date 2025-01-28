package oops6.comparingobjects;

public class Student implements Comparable<Student>{
    int rollno;
    float marks;

    public Student(int rollno, float marks) {
        this.rollno = rollno;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return marks + "";
    }

    @Override
    public int compareTo(Student o) {
        System.out.println("in compareto method");
        int diff = (int)(this.marks - o.marks);

        // if diff == 0: means both are equal
        // if diff < 0: means o is bigger else o is smaller

        return diff;
    }
}


// we can compare objects using the "COMPARABLE" interface in java.
// we can also have a interface with generic types.
// "compareTo" method from "comparabl" interface.