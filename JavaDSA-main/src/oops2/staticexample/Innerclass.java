package oops2.staticexample;


// outer class cannot be a static class but inner class can be static why?

//class Test { // it now not dependent on the object of the Innerclass - so it will work
//    static  String name;
//    public Test(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public String toString() {
//        return name;
//    }
//}

// output is for above
// Rahul
// Rahul
public class Innerclass {

    static class Test { // it now not dependent on the object of the Innerclass - so it will work
        String name;
        public Test(String name) {
            this.name = name;
        }

        @Override
        public String toString() {

            return name;
        }
    }

    public static void main(String[] args) {
        Test a = new Test("Kunal"); // for the above Test class if we remove static it will error why? because
        // when declared as a static it will not be dependent on object of Innerclass.

        Test b = new Test("Rahul");

        System.out.println(a);

       System.out.println(a.name);
       System.out.println(b.name);

      // what will be the output will be now? for the above static inner class?
        // kunal
        // Rahul
        // how? because the main and static Test class can depend on each-other so it can have instance of it own.
    }
}


// Oops 2 time stamp 1:00 hour is very important.

// static methods are resolved at compile time instead of runtime why?