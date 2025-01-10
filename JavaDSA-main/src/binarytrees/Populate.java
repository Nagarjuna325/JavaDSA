package binarytrees;

public class Populate {

    public Node connect(Node root) {

        if( root == null){
            return null;
        }

        Node leftMost = root;

        while( leftMost.left != null){ // error what ha
            Node current = leftMost; // why we are using current variable beacuse we need to have the current node stored at a place to point to the it right
            while( current != null){ // moved my current pointer to next level //1
                // 1.2.4 = 2.5 // so pointer b/w 4 and 5 is established
                current.left.next =  current.right;

                if( current.next != null){ //current is 2

                    current.right.next = current.next.left; // 5 $ 6 will be connected
                }

                current = current.next; // setting the current to next level-4

            }

            leftMost = leftMost.left;

        }


        return  root;
    }



    // used to print the output in the expected format

    public static void printTreeByLevel(Node root) {
        Node levelStart = root;

        while (levelStart != null) {
            Node current = levelStart;

            while (current != null) {
                System.out.print(current.val + " -> ");
                current = current.next;
            }
            System.out.println("null");
            levelStart = levelStart.left;
        }
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Populate pop = new Populate(); // creating a object

        pop.connect(root); // calling the method with the object name

        printTreeByLevel(root); // printing the output in the format
    }

}
