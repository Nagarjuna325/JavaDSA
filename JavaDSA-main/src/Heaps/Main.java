package Heaps;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception{
        Heaps<Integer> heap = new Heaps<Integer>();

        heap.insert(34);
        heap.insert(45);
        heap.insert(22);
        heap.insert(89);
        heap.insert(76);



        System.out.println(heap);

        ArrayList<Integer> list = heap.heapSort();

        // heapsort is also known as priority queue.
        // means minimum item and maximum item means priority queue
        System.out.println(list);

        //System.out.println(heap.remove());


        // ❌ Don't call remove() after heapSort(), as heap is now empty
        // System.out.println(heap.remove());  // ❌ This would cause an error
        // important write 17th line at 25 and run u see empty
    }
}


//why should we cannot overide he tosrting method in main method why?


//Why Can't We Override toString() in the main Method?
//        In Java, method overriding happens between a subclass and a superclass. The main method is inside a static context (inside the Main class) and does not belong to the Heaps class, so you cannot override toString() inside main.
//
//Key Reasons Why Overriding toString() in main Does Not Work
//toString() belongs to an instance, not a static method
//
//The main method is static, meaning it belongs to the class and not an object.
//Overriding works with instance methods (non-static), so toString() must be in the Heaps class.
//Overriding must happen inside the same class hierarchy
//
//You can only override toString() if Main extends Heaps (which it does not).
//Instead, Main is just a separate class running the program.
//Java does not allow method definitions inside another method
//
//Java does not allow defining a method (like toString()) inside main().
//Methods should be defined inside a class and outside any other method.
//Correct Way to Override toString()
//You should override toString() in the Heaps class, not inside main().
//
//        ❌ Wrong Approach (Does Not Work)
//java
//        Copy
//Edit
//public class Main {
//    public static void main(String[] args) {
//        Heaps<Integer> heap = new Heaps<>();
//
//        public String toString() {  // ❌ This is invalid
//            return "Heap: " + heap.toString();
//        }
//
//        System.out.println(heap);
//    }
//}
//❌ Error: Java does not allow method definitions inside main().
//
//        ✅ Correct Approach (Works)
//Override toString() inside Heaps class:
//
//java
//        Copy
//Edit
//class Heaps<T extends Comparable<T>> {
//    private ArrayList<T> list = new ArrayList<>();
//
//    @Override
//    public String toString() {
//        return "Heap: " + list.toString();  // ✅ Correctly overriding toString()
//    }
//}
//Then, in main(), simply print the heap:
//
//java
//        Copy
//Edit
//public class Main {
//    public static void main(String[] args) {
//        Heaps<Integer> heap = new Heaps<>();
//        heap.insert(10);
//        heap.insert(20);
//        heap.insert(5);
//
//        System.out.println(heap);  // ✅ This automatically calls the overridden toString()
//    }
//}
//Expected Output
//makefile
//        Copy
//Edit
//Heap: [5, 20, 10]
//Final Answer
//You cannot override toString() in main() because:
//
//Method definitions cannot be inside another method in Java.
//toString() must be inside the class you want to modify (Heaps).
//Overriding only works between a subclass and a superclass (which Main and Heaps are not).
//Let me know if you need further clarification! 🚀

