package Heaps;

import binarytrees.Node;

import java.util.ArrayList;

public class Heaps<T extends Comparable<T>> {

    // why we used extends with Comparable because to compare two objects we use comparable in java

    private ArrayList<T> list;



    @Override
    public String toString() {

        return "Heap: " + list.toString();
    }

    // constructor declaration for class Heaps

    public Heaps(){
        list = new ArrayList<>();
    }

    // swap method declaration
    private void swap(int first, int second){
        T temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }

    // why we took so we are taking from index i =0 so 1-1 = 0/2=0

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int left(int index) {
        return index * 2 + 1;
    }

    // 1*2+1 = 3 so starts from 1 to N but
    private int right(int index) {
        return index * 2 + 2;
    }


    // inserting the value AT LAST
    public void insert(T value) {
        list.add(value);  // so list will add at the last now and then we start comparing from bottom to top to swap
        // it is called as UP - HEAP.
        upheap(list.size() - 1);
    }

    //
    private void upheap(int index) {
        if(index == 0) {
            return;
        }
        int p = parent(index);
        if(list.get(index).compareTo(list.get(p)) < 0) {
            swap(index, p);
            upheap(p);
        }
    }

    public T remove() throws Exception {
        if (list.isEmpty()) {
            throw new Exception("Removing from an empty heap!");
        }
    // REMOVING THE item at 0 th index and swap the last index at the 0 th index
        T temp = list.get(0);

        T last = list.remove(list.size() - 1);

        if (!list.isEmpty()) {
            list.set(0, last);

            // now top to bottom comparision and moving and swaping
            downheap(0);
        }

        return temp;
    }


    private void downheap(int index) {

        // setting the current element we are at that is top element as to min and comparing left and right element and swaping

        int min = index;

        // same the calling left method to calculate it and assigning it to left variable.
        int left = left(index);


        int right = right(index);


        // so one main thing we need to very carefull here is we are comparing the whether index is ther are not at first
        // by using list.size() with left index we have not the value and then we are going to check
        // value(objects value) with the min value using the list.get(min).compareTo to checks values

        if(left < list.size() && list.get(min).compareTo(list.get(left)) > 0) {
            min = left;
        }

        if(right < list.size() && list.get(min).compareTo(list.get(right)) > 0) {
            min = right;
        }


        // this only execute if the left or right is smaller then top index we are at which is  assigned to  variable min now
        if(min != index) {
            swap(min, index);
            downheap(min);
        }
    }

    public  ArrayList<T> heapSort() throws Exception {
        ArrayList<T> data = new ArrayList<>();

        // heapsort means removing all the elements from the heap and keeping it in a list and the values will be in the
        // sorted order
        // so still the heap is empty remove the items from it an add it to the data list we created
        // each item removing in heap takes O(logn) tIME COMPLEXITY SO REMOVING N elements O(nlogn)-TC - heapsort
        while(!list.isEmpty()) {
            data.add(this.remove());  // this keyword we used here to represent current object which is data
        }
        return data; // and return the data.
    }

    // heap sort time complexity - O(NlogN)

}
