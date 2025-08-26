package linkedlist;

public class Main {

    public static void main(String[] args) {


        Lll list = new Lll();
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(8);
        list.insertFirst(17);
        list.insertLast(99);
        list.insert(100, 3);

        list.display();




    }
}
