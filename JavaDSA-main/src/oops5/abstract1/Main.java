package oops5.abstract1;

public class Main {
    public static void main(String[] args) {
        Son son = new Son(30);
        son.career();

        son.normal();

        // Parent daughter = new Parent(28); - error find out why?
        Parent daughter = new Daughter(28);
        daughter.career();

        Parent.hello();
//        Parent mom = new Parent(45);
    }
}
