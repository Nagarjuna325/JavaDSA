package oops2.singleton;

public class Main {

    public static void main( String[] args){

        Singleton obj1 = Singleton.getInstance();

        Singleton obj2 = Singleton.getInstance();  // obj2 gets to obj1 value only , reference will be pointing to it in the heap memory.

        Singleton obj3 = Singleton.getInstance();
        // all 3 ref variables are pointing to just one object value.

        // only one object is created in the memory using the condition checking in getInstance(){}
        // and how many objects we create their reference will be pointing to that.

    }
}
