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
