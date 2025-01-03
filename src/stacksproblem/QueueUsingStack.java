package stacksproblem;

// import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.jupiter.api.Test;
import java.util.*;


// public class Main {
//   public static void main(String[] args) {
//     Stack<Integer> stack = new Stack<>();
//     stack.push(5);
//     System.out.println(stack.pop());
//   }

// @Test
// void addition() {
//     assertEquals(2, 1 + 1);
// }
//}



// Queue using stack

public class QueueUsingStack {
    private Stack<Integer> first; // instance variable declaration - very important
    //using constructors are used for declaration and intistation. same thing in python we use self in a function defintion and declare the variables.
    // and also java this keyword same as explicit self we use this keyword in java when there is a amibuity in binding same variable names in both class and methods to bind which one so there we use this.- which binds to current instance of the method not implicitly to the class instance of the variable.
    private Stack<Integer> second;

    // creating constructor to intialize the variables
    public QueueUsingStack() {
        first = new Stack<>();
        second = new Stack<>();

    }

    public void add(int item){

        first.push(item);
    }

    public int remove() throws Exception { // we are using O(n) operations for removing

        while(!first.isEmpty()) second.push(first.pop()); // first.pop will return an item

        int removed = second.pop();

        // Now we need to again put back all the items at same place in first stack from second one

        while(!second.isEmpty()){
            first.push(second.pop());
        }

        return removed;
    }


    public int peek() throws Exception {
        while (!first.isEmpty()) {
            second.push(first.pop());
        }

        int peeked = second.peek();

        while (!second.isEmpty()) {
            first.push(second.pop());
        }
        return peeked;
    }


    // checking if first is empty or not
    public boolean isEmpty(){
        return first.isEmpty();
    }

}