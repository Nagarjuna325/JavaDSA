package tree;

public class TreeAvl {


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

    public TreeAvl(){

    }

    public int height(Node node){
        if( node == null){
            return -1;
        }

        return node.height;
    }

    public int height(){
        return height(root);
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

        return rotate(node);


    }


    private Node rotate(Node node){

        if( height(node.left) - height( node.right) > 1){
          // left heavy

            if( height( node.left.left) - height(node.left.right) > 0) {
                // left left case
                return rightRotate(node);
            }

            if( height( node.left.left) - height(node.left.right) < 0) { // -ve value diagram 2
                // left right case
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        // 3 , 4 diagrams
        if( height(node.left) - height( node.right) < -1){
            // right heavy

            if( height( node.right.left) - height(node.right.right) < 0) {
                // right right case
                return leftRotate(node);
            }

            if( height( node.right.left) - height(node.right.right) > 0) { // -ve value diagram 2
                //  right left case
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node; // other wise just returns

    }


    // implementing the rotate part now

    public Node rightRotate(Node p){  // diagram 4.2

        Node c = p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;

        // updating the heights after rearranging
        p.height = Math.max( height(p.left), height(p.right) + 1);
        c.height = Math.max( height(c.left), height(c.right) + 1);

        // as c becomes Node now after rearranging
        return c;
    }

  // left rotate part

    public Node leftRotate(Node c){  // diagram 4.2

        Node p = c.right; // rotating left but the node value we are rotating t1
        Node t = p.left;

        p.left = c;
        c.right = t;

        // updating the heights after rearranging
        p.height = Math.max( height(p.left), height(p.right) + 1);
        c.height = Math.max( height(c.left), height(c.right) + 1);

        // as c becomes Node now after rearranging
        return p;
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
        TreeAvl tree = new TreeAvl();
         //int[] nums = { 5, 2, 7, 1, 4, 6, 9, 8, 3, 10 };
        int[] nums = { 2,6,8,9,10,11,13, 16, 19, 20}; // major issue with trees, So to solve this issue we use self balanced
        // trees which is AVL trees.
        tree.populate(nums);
        //tree.populatedSorted(nums);
        tree.display();
        // insertion complexity
        System.out.println( tree.height());
    }
}