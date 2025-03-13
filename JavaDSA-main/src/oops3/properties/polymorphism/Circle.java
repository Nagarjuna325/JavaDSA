package oops3.properties.polymorphism;

public class Circle extends Shapes {

    // this will run when obj of Circle is created
    // hence it is overriding the parent method
    @Override
    // this is called annotation - @Override is a simply checker to check whether the method is overiden or not.
    public void area() {
        System.out.println("Area of Circle");
    }

}


