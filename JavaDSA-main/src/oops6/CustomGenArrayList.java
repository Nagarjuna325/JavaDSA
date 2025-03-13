package oops6;
import java.util.ArrayList;
import java.util.Arrays;

// generic were introduced in java , it is checked at compile time only. SO why we need to observe this point carefully?

// static fields whose type is of type parameter is not allowed
// static T vas;- not allowed what is the type of vas , we dont know as we dont what type is T of yet.
// cannot use casts or instanceof with Parameterized Types.

// https://docs.oracle.com/javase/tutorial/java/generics/restrictions.html#createObjects
public class CustomGenArrayList<T> {
    private Object[] data;  // if we use  T[] data - we will get error why?
    private static int DEFAULT_SIZE = 10;
    private int size = 0; // also working as index value

    public CustomGenArrayList() {
        data = new Object[DEFAULT_SIZE];
    }

    public void add(T num) {
        if (isFull()) {
            resize();
        }
        data[size++] = num;
    }

    private void resize() {
        Object[] temp = new Object[data.length * 2];

        // copy the current items in the new array
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    private boolean isFull() {
        return size == data.length;
    }

    public T remove() {
        T removed = (T) data[--size];
        return removed;
    }

    public T get(int index) {
        return (T)data[index];
    }

    public int size() {
        return size;
    }

    public void set(int index, T value) {
        data[index] = value;
    }

    @Override
    public String toString() {
        return "CustomGenArrayList{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
//        ArrayList list = new ArrayList();
        CustomGenArrayList list = new CustomGenArrayList();
//        list.add(3);
//        list.add(5);
//        list.add(9);

//        for (int i = 0; i < 14; i++) {
//            list.add(2 * i);
//        }

//        System.out.println(list);

        ArrayList<Integer> list2 = new ArrayList<>();
//        list2.add("dfghj");


        CustomGenArrayList<Integer> list3 = new CustomGenArrayList<>();
        for (int i = 0; i < 14; i++) {
            list3.add(2 * i);
        }

        System.out.println(list3);

    }
}


// we cannot create an Instance- means object of Type parameters. why?
// because if the compiler does not know what type how does it will understand it which is converted to byte code so it gives compile time error.

//  T num = new T(); - not possible.

// but if we want to create an object of a type parameter we do it through "REFLECTION"

//        public static <E> void append(List<E> list, Class<E> cls) throws Exception {
//            E elem = cls.newInstance();   // OK
//            list.add(elem);
//        }


// wildcards in java?
//