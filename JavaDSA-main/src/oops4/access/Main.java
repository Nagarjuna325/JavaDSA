package oops4.access;

public class Main {
    public static void main(String[] args) {
        A obj = new A(10, "Kunal");
        // need to do a few things
        // 1. access the data members
        // 2. modify the data members

//        ArrayList<Integer> list = new ArrayList<>(23);
//        list.DEFAULT_CAPACITY; // error we cannot access the variable DEFAULT_CAPACITY which is in arralist class which is private.


        obj.getNum();
        int n = obj.num;
    }
}


// in the different package it will not allow if no access specifier is mentioned - by default it is public.

//