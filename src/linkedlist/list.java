package linkedlist;

public class list {

    public static void main( String[] args){

//        Lll list = new Lll();
//
//        list.insertFirst(10);
//        list.insertFirst(10);
//        list.insertFirst(10);
//        list.insertFirst(15);
//        list.insertLast(20);
        //list.insert(100, 3);
        // list.display();
//        System.out.println(list.deleteFirst());
//        list.display();
//        System.out.println(list.deleteLast());
//        list.display();
//        System.out.println(list.delete(2));
//        list.display();
//        list.insertRec(88, 2);
//        list.display();

        //list.duplicates();
        //list.display();


        // 21 solution code

        Lll first = new Lll();
        Lll second = new Lll();

        first.insertLast(1);
        first.insertLast(2);
        first.insertLast(6);
        first.insertLast(15);

        second.insertLast(1);
        second.insertLast(2);
        second.insertLast(10);


        Lll ans = Lll.merge(first, second);

        ans.display();

    }
}
