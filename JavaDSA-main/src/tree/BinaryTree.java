package tree;

import java.util.Scanner;


// implementing using LinkedList

public class BinaryTree {


    public BinaryTree(){ // constructor

    }


    private static class Node{ // Node class creation

        int value;
        Node left;
        Node right;

        public Node(int value){ //constructor
            this.value = value;
        }
    }


    private Node root;

    public void populate(Scanner scanner){
        System.out.println("Enter the root Node:");
        int value = scanner.nextInt(); //value given 15
        root = new Node(value); // after having the root now we will use the recrusion function to call and put the values
           // above root sets the 15 to root node
        populate(scanner, root); // recrusive function call
    }



    private void populate(Scanner scanner, Node node){  // recrusion function
        System.out.println("Do you want to enter left of" + node.value); // node.value = 15 1st level

        boolean left = scanner.nextBoolean(); // yes
        if(left){
            System.out.println(" enter the  left value:" + node.value);
            int value = scanner.nextInt(); // 6 -2nd level
            node.left = new Node(value);
            populate(scanner, node.left); // now we are inside 6 and it will again call the where to call left are right
        }


        System.out.println("Do you want to enter right of" + node.value);
        boolean right = scanner.nextBoolean(); // yes
        if(right){
            System.out.println(" enter the  right value:" + node.value);
            int value = scanner.nextInt(); //
            node.right = new Node(value);
            populate(scanner, node.right); //
        }

    }


    public void display(){
        display(root,"");
    }


    private void display(Node node, String indent){ // indent is a space just we provide
        if (node == null) {
            return;
        }
        System.out.println(indent + node.value);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
    }


    // Pre-order , post-order , In-order

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        preOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        preOrder(node.left);
        System.out.print(node.value + " ");
        preOrder(node.right);
    }

    public void postOrder() {
        preOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        preOrder(node.left);
        preOrder(node.right);
        System.out.print(node.value + " ");
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         BinaryTree tree = new BinaryTree();
        tree.populate(scanner);
        // tree.prettyDisplay();

        //BinaryTree tree = new BinaryTree();
        //int[] nums = { 5, 2, 7, 1, 4, 6, 9, 8, 3, 10 };
        //tree.populate(nums);
        tree.display();
    }

    
}


//what is Binary Tree all the left values is less the right side side right?
//ChatGPT said:
//Yes! In a Binary Tree, there are no strict rules about the values of the left and right child nodes. However, if you're referring to a Binary Search Tree (BST), then the rule is:
//
//For each node in a BST:
//
//Left subtree contains values less than the node.
//Right subtree contains values greater than the node.
//Example of a Binary Search Tree (BST):
//markdown
//        Copy
//Edit
//       8
//               / \
//               3   10
//               / \    \
//               1   6    14
//               / \   /
//               4   7 13
//               ✅ BST properties are satisfied:
//
//Left of 8: 3, 1, 6, 4, 7 (all < 8)
//Right of 8: 10, 14, 13 (all > 8)
//Left of 3: 1 (all < 3)
//Right of 3: 6, 4, 7 (all > 3 but < 8)
//What About a Regular Binary Tree?
//A Binary Tree (BT) only follows the rule that each node has at most 2 children. There are no constraints on the values of the left or right child.
//
//Example of a Regular Binary Tree (Not a BST):
//markdown
//        Copy
//Edit
//       5
//               / \
//               10  2
//               / \   \
//               3   7   8
//               🚫 Not a BST because:
//
//        10 (left child of 5) is greater than 5.
//        2 (right child of 5) is less than 5.
//Key Differences:
//Property	Binary Tree (BT)	Binary Search Tree (BST)
//Node Values	No ordering rule	Left < Root < Right
//Searching	O(N) worst case	O(log N) if balanced
//Use Case	General-purpose tree structure	Efficient searching & sorting
//Would you like a Java implementation to check if a given Binary Tree is a BST? 🚀
//
//
//
//
//
//
//
//You said:
//so in the the sense a binary tree can have a one child to parent or two also right but not more than 2?
//ChatGPT said:
//Yes, exactly! In a Binary Tree (BT):
//        ✅ Each node can have at most two children (left and right).
//        ✅ A node can have zero, one, or two children.
//❌ A node cannot have more than two children.
//
//Examples:
//        ✅ Valid Binary Trees
//1️⃣ A Full Binary Tree (Each node has 0 or 2 children)
//
//markdown
//        Copy
//Edit
//       1
//               / \
//               2   3
//               / \   \
//               4   5   6
//               👉 Every node has either zero or two children.
//
//        2️⃣ A Binary Tree with Some Nodes Having One Child
//
//        markdown
//Copy
//        Edit
//       1
//               /
//               2
//               / \
//               3   4
//               👉 Here, node 1 has only one child (2), and node 2 has both left (3) and right (4).
//
//        ❌ Invalid Binary Tree (More than 2 children)
//🚫 This is NOT a Binary Tree because node 1 has three children:
//
//markdown
//        Copy
//Edit
//       1
//               / | \
//               2  3  4
//               👉 This is called a General Tree, not a Binary Tree.
//
//Types of Binary Trees
//Type	Description
//Full Binary Tree	Every node has 0 or 2 children.
//Complete Binary Tree	Every level is filled except possibly the last.
//Perfect Binary Tree	Every level is completely filled.
//Balanced Binary Tree	Height is O(log N) (e.g., AVL, Red-Black Tree).
//Degenerate (Skewed) Tree	Each node has only one child (like a linked list).
//Would you like a Java function to check if a given tree is a Full or Complete Binary Tree? 🚀
