package oops7.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();

//        list2.add(34);
//        list2.add(78);
//        list2.add(55);
//        list2.add(89);
//
//        System.out.println(list2);


        List<Integer> vector = new Vector<>();
        vector.add(45);
        vector.add(5);
        vector.add(15);
        vector.add(56);

        //List<Integer> vector2 = new List<Integer>(); - Think why error?

        System.out.println(vector);
    }
}


// what is collection framework?
// it provides a common interface for all the datatypes means we have lot of datatypes in java , arrays , list , hashmap..
// and lot of this have a so many methods so if we want to remember it will be little bit difficult so we use a common framwokr
// what it will do it will combine the methods which are common for both datatypes and using interface extends it or implements it can we can use.
// "vector datatype" is synchrozied means only one thread can acess it.
// "arraylist datatype" multiple threads can access its objects at the sametime.
// arraylist is faster. why?
//