package oops5.Interface;

public class Main {
    public static void main(String[] args) {
    //        Engine car = new Car();
//        car.a;
         // above 2 line very important which one to access and which type can access depends on ref and type of object.
//        car.acc();
//        car.start();
//        car.stop();
//        Media carMedia = new Car();
//        carMedia.stop();


    NiceCar car = new NiceCar();

        car.start();
        car.startMusic();
        car.upgradeEngine();
        car.start();
}
}
