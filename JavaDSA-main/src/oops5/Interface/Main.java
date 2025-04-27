package oops5.Interface;

public class Main {
 public static void main(String[] args) {
    //        Engine car = new Car();
//        car.a;  // so this gives us error? why and explain to me.
         // above 2 line very important which one to access and which type can access depends on ref and type of object.
     // which one we can access depends on the type of reference variable , and which type(version)(that means constructor - in this case we will use Child constructor Car only.) we can access depends on the
//        car.acc();  // in simple here if see car.acc() - it will print Car acc not the Engines. one so thats what the left side new Car()- tells which version to access.
//        car.start();
//        car.stop();

//        Media carMedia = new Car();  what is the problem we are getting due to this? and how we solved it.
//        carMedia.stop();


        NiceCar car = new NiceCar();

        // very important code the below 2 lines understand it carefully.
        car.start();
        car.startMusic();

        // below 2 lines is very important and also the output
        car.upgradeEngine();
        car.start();

        // Power engine start
       // Music start
       // Electric engine start - if we observe here without creating a new object we changed the engine type to other using above line of code
     // upgrade.
}
}
