package oops6.exceptionHandling;

public class Main {
    public static void main(String[] args) {
        int a = 5;
        int b = 0;
        try {
//            divide(a, b);
            // mimicing
            String name = "Kunal";
            if (name.equals("Kunal")) {
                throw new MyException("name is kunal");
            }
        } catch (MyException | ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) { // Exception is a class which has getMessage() method.
            System.out.println("normal exception");
        } finally {
            System.out.println("this will always execute"); //
        }

    }

    static int divide(int a, int b) throws ArithmeticException{
        if (b == 0) {
            throw new ArithmeticException("please do no divide by zero");
        }

        return  a / b;
    }
}


// throwable extends objects class so throwable is a subclass.

// what is an error and an exception?
// error occurs due to some resources missing or something like stackoverflow. we cannot recover from it.
// on the other hand exceptions are breaks in normal flow of the program we can come out of the exceptions.

// throwable is the class in exceptions which deals with exceptions in java

// 2 types 1. exception 2. errors.
// exceptions are of 2 types.
// 1. checked - compile time exceptions like file location not wrong .
// 2. unchecked - other detected only at run time like arthematic exception.

// exception is a class

// when we want to throw an exception explicity we can use "throw" and we use to throw the exception
// "throws" we use to declare an exception.


