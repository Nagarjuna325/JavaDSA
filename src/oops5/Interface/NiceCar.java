package oops5.Interface;

public class NiceCar {
    private Engine engine;
    private Media player = new CDPlayer();  // observe carefully here - very important
    // we are creating an object to interface here or not? - Answer no - we are object to CDPlayer , which is a class type.
    // but if we do like this Media player = new Media(); - we will get error why?, because we cannot an object(instance)
    // to an interface thats why it will give us error.

    public NiceCar() {
        engine = new PowerEngine();
    } // constructor

    public NiceCar(Engine engine) {
        this.engine = engine;
    } // parameterized constructor

    public void start() {
        engine.start();
    }

    public void stop() {
        engine.stop();
    }

    public void startMusic() {
        player.start();
    }

    public void stopMusic() {
        player.stop();
    }

    public void upgradeEngine() {
        this.engine = new ElecticEngine();
    }
}
