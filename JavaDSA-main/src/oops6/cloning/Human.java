package oops6.cloning;

public class Human implements Cloneable{

    int age;
    String name;


    // shallowandDeepcopy
    int[] arr;

    public Human(int age,String name) {
        this.age= age;
        this.name = name;
        this.arr = new int[]{1,2,5,7,8};
    }

    public Human(Human other) {
        this.age = other.age;
        this.name = other.name;
    }

    public Object clone() throws CloneNotSupportedException {
        // return super.clone();

        Human twin = (Human)super.clone(); //shallow copy

        // making a deep copy
        twin.arr = new int[twin.arr.length];  // so we can  also check it now in main class
        for(int i = 0; i< twin.arr.length; i++){
            twin.arr[i] = this.arr[i];
        }

        return twin;
    }
}


// clone is a making a copy of the same object.
// it is implemented by clonable.