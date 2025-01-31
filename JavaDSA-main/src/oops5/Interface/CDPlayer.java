package oops5.Interface;

public class CDPlayer implements Media {
    @Override
    public void start() {
        System.out.println("Music start");
    }

    @Override
    public void stop() {
        System.out.println("Music stop");
    }
}


 //implementing separate class for interface. why we need this?
