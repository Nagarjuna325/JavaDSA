package binarytrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();


        // if root is null return null

        if (root == null) {
            return result;
        }

        // why the type of queue is TreeNode not integer or float becuase we are using TreeNode datatype(which is class values to store so we will name it as same type).

        // if I start from root I need to have a queue first right
        Queue<TreeNode> queue = new LinkedList<>();
        // at first root node so adding it to the queue by using offer method which adds from the end of the queue we can use add() method also but it will
        //give us error if we have a outof bound data in queue for storing but offer silently fails thats it.- means gives false , doesnt show error
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize); // to store current level list values
            // even if wont use levelSize also it wont give u error
            for (int i = 0; i < levelSize; i++) {
                // the node which we are removing from the queue we added before to the queue at first step it is 1 in the queue
                // it will ne now removed from queue and we aslo,set it as the node for the Tree
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val); // stores the value of the node in the level list
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            //So after finishing the above for loop the currentLevel list will have a values which we can add to result.

            result.add(currentLevel);
        }
        return result;
    }


    public TreeNode findSuccessor(TreeNode root, int key) {


        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);


        while (!queue.isEmpty()) {
            int levelSize = queue.size();

                TreeNode currentNode = queue.poll();

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
                if( currentNode.val == key) {
                     break;
                }
        }
        return queue.peek();


//        "Everything in Java is Strings for JVM"
//        This is not entirely accurate. While Java provides robust support for converting objects to strings (like toString()), the JVM doesn't treat everything as strings. Here's why:
//
//        Data Types: The JVM recognizes many data types (e.g., int, double, boolean, objects, etc.). These are managed based on their specific type, not as strings.
//        String Representation: When we print an object or primitive value, Java converts it to a string (via methods like toString() for objects or string concatenation). This is for convenience, not because the JVM inherently treats everything as strings.
//        JVM Internals: Under the hood, the JVM uses binary representations for primitives and objects and does not treat them as text or strings.
//        Conversion to Strings
//        Java's flexibility with toString() and string concatenation (+) might give the impression that everything is treated as strings because these operations are so common. However:
//
//        Strings are managed by the JVM's String Pool, which is a special part of memory.
//        Primitives and objects have their native representations in memory and are only converted to strings when needed (e.g., for printing or concatenation).


//        int num = 42;
//        System.out.println(num); // The primitive int is converted to "42" as a string for printing.
//
//        Object obj = new Object();
//        System.out.println(obj); // Calls obj.toString() (default implementation) to get a string representation.


    }



    public static void main(String[] args) {
            int key = 3;
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);

            BFS bfs = new BFS();
            //List<List<Integer>> result = bfs.levelOrder(root);
            TreeNode result = bfs.findSuccessor(root , key);
            System.out.println(result);
        }



}

//queue.offer(E e)
//Purpose: Adds an element to the end (tail) of the queue.
//Return Value:
//Returns true if the element is successfully added.
//If the queue has a capacity limit (e.g., in a bounded queue), it returns false if no space is available.
//Usage: Safer than add() because it does not throw an exception if the operation fails due to capacity constraints.

//queue.poll()
//Purpose: Retrieves and removes the head (front) of the queue.
//Return Value:
//Returns the head of the queue, or null if the queue is empty.
//Usage: Safer than remove() because it does not throw an exception if the queue is empty.


//Python code

//from collections import deque
//from typing import List, Optional
//
//class TreeNode:
//def __init__(self, val: int = 0, left: 'TreeNode' = None, right: 'TreeNode' = None):
//self.val = val
//self.left = left
//self.right = right
//
//class BFS:
//def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
//result = []
//
//        if not root:
//        return result
//
//        queue = deque([root])
//
//        while queue:
//level_size = len(queue)
//current_level = []
//
//        for _ in range(level_size):
//current_node = queue.popleft()
//                current_level.append(current_node.val)
//
//                if current_node.left:
//        queue.append(current_node.left)
//
//                if current_node.right:
//        queue.append(current_node.right)
//
//            result.append(current_level)
//
//        return result


// Doubts

//why we used just while queue in python and in java while (!queue.isEmpty()) we caan also use while(queue) right like this in Java
//ChatGPT said:
//ChatGPT
//No, you cannot use while(queue) in Java because of how Java handles conditional expressions compared to Python.
//
//Key Differences
//In Python:
//
//A deque is treated as a truthy value when it is not empty and falsy when it is empty.
//        Therefore, while queue: is valid and idiomatic in Python. It automatically checks if the deque is non-empty.
//In Java:
//
//A Queue object does not have a direct "truthy" or "falsy" interpretation.
//        The while condition in Java must evaluate to a boolean value (true or false).
//You explicitly check if the queue is non-empty using !queue.isEmpty(), as queue itself cannot be directly used as a condition.
//Why while(queue) Doesn't Work in Java
//        In Java, queue is an object reference. Using it directly in a while loop condition (e.g., while(queue)) will result in a compilation error because Java does not allow object references to be treated as booleans.
//Comparison Table
//Feature	Python	Java
//Truthy/Falsy for Queues	deque is truthy when non-empty	No direct truthy/falsy interpretation
//Example for Non-Empty	while queue:	while (!queue.isEmpty())
//Compilation Error	No	Yes, if while(queue) is used
//Example in Python
//        python
//Copy code
//from collections import deque
//
//        queue = deque([1, 2, 3])
//
//        while queue:
//print(queue.popleft())  # Removes and processes elements
//Output:
//
//Copy code
//1
//        2
//        3
//Equivalent Java Code
//        java
//Copy code
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class Main {
//    public static void main(String[] args) {
//        Queue<Integer> queue = new LinkedList<>();
//        queue.offer(1);
//        queue.offer(2);
//        queue.offer(3);
//
//        while (!queue.isEmpty()) {
//            System.out.println(queue.poll());  // Removes and processes elements
//        }
//    }
//}
//Output:
//
//Copy code
//1
//        2
//        3
//Conclusion
//Python: while queue is concise and works because of Python's truthy/falsy behavior for containers.
//Java: You must explicitly check !queue.isEmpty() because Java lacks truthy/falsy evaluation for objects.
//
//



// doubt2

//TreeNode currentNode = queue.poll(); why we need to have TreeNode we can just assign the removed value to currentNode =queue.poll() like this right
//ChatGPT said:
//ChatGPT
//No, you cannot directly assign the result of queue.poll() to currentNode without explicitly specifying the type (e.g., TreeNode) in Java. Java is a statically typed language, meaning the type of every variable must be explicitly declared.
//
//Why Do We Need TreeNode in Java?
//Static Typing:
//
//Java requires you to define the type of a variable at the time of its declaration.
//The queue.poll() method returns a value of type TreeNode because the queue is defined as Queue<TreeNode>.
//Therefore, the variable currentNode must be declared as a TreeNode to store the returned value.
//Type Safety:
//
//Declaring currentNode as TreeNode ensures that the compiler knows its type.
//This allows the compiler to catch errors if you try to use currentNode in an incompatible way.
//Example in Java
//        java
//Copy code
//Queue<TreeNode> queue = new LinkedList<>();
//queue.offer(new TreeNode(1));  // Add a TreeNode to the queue
//
//// Correct way:
//TreeNode currentNode = queue.poll();  // Explicitly declare currentNode as TreeNode
//
//// Incorrect way:
//currentNode = queue.poll();  // Compilation error: currentNode is not declared
//Why Can't We Skip the Type?
//        In Java, the poll() method only returns the value, and the variable you assign it to must already be declared with a compatible type.
//
//If you try to do this:
//
//java
//Copy code
//currentNode = queue.poll();  // Error
//You will get a compilation error because currentNode has not been declared yet.
//
//Comparison to Python
//        In Python, you don’t need to explicitly declare variable types because Python is dynamically typed:
//
//python
//Copy code
//queue = deque([TreeNode(1)])  # Add a TreeNode to the deque
//currentNode = queue.popleft()  # No type declaration needed
//Here, Python automatically infers the type of currentNode based on the value returned by queue.popleft().
//
//Why Java Requires Explicit Declaration
//Java enforces type declaration for several reasons:
//
//Compile-Time Type Checking:
//
//Errors are caught early during compilation rather than at runtime.
//Helps avoid runtime errors caused by type mismatches.
//Performance:
//
//Static typing allows the compiler to optimize code more effectively.
//Key Takeaway
//In Java:
//
//You must explicitly declare currentNode as TreeNode because Java requires variables to have a declared type.
//        In Python, type declaration is unnecessary because the language is dynamically typed.
//

