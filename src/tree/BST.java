package tree;

public class BST {

    public class Node{

        private int value;
        private Node left;
        private Node right;
        private int height;

        // constructor defining for it
        public Node(int value){
            this.value = value;
        }

        public int getValue(){
            return value;
        }

    }

   private Node root;

    public BST(){

    }

    public int height(Node node){
        if( node == null){
            return -1;
        }

        return node.height;
    }

    public boolean isEmpty(){
        return root == null;

    }

    public void insert( int value){
        root = insert(value , root);
    }


    private Node insert(int value, Node node){
        if( node == null){
            node = new Node(value);
            return node;
        }

        if( value < node.value){
            node.left = insert(value , node.left);

        }

        if( value > node.value){
            node.right = insert(value , node.right);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return node;


    }


    // inserting the multiple items

    public void populate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            this.insert(nums[i]);
        }
    }

    public void populatedSorted(int[] nums) {
        populatedSorted(nums, 0, nums.length);
    }

    private void populatedSorted(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;

        this.insert(nums[mid]);
        populatedSorted(nums, start, mid); // for left
        populatedSorted(nums, mid + 1, end); // right array
    }






    // displaying the values

    public void display() {
        display(this.root, "Root Node: ");
    }

    private void display(Node node, String details) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.value); // first prints 15
        display(node.left, "Left child of " + node.value + " : "); // 10 left child of 15
        display(node.right, "Right child of " + node.value + " : ");
    }




    // using encapsulation

    public boolean balanced() {
        return balanced(root);
    }

    private boolean balanced(Node node) {
        if (node == null) {
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }



    public static void main(String[] args){
        BST tree = new BST();
        //int[] nums = { 5, 2, 7, 1, 4, 6, 9, 8, 3, 10 };
        int[] nums = { 2,6,8,9,10,11,13, 16, 19, 20}; // major issue with trees, So to solve this issue we use self balanced
        // trees which is AVL trees.
        //tree.populate(nums);
        tree.populatedSorted(nums);
        tree.display();
    }

}

// output

//Root Node: 5
//Left child of 5 : 2
//Left child of 2 : 1
//Right child of 2 : 4
//Left child of 4 : 3
//Right child of 5 : 7
//Left child of 7 : 6
//Right child of 7 : 9
//Left child of 9 : 8
//Right child of 9 : 10


// What is the problem with this Binary search trees is
// if they gave the array as a sorted then it will have output in one sided.
