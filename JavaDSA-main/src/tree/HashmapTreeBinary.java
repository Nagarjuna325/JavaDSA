package tree;

import java.util.HashMap;

public class HashmapTreeBinary {


    //static int index = 0;  why it does not worked
    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i =0; i < inOrder.length; i++){
            map.put(inOrder[i],i); // to put all the elements in the HashMap data structure from inOrder ARRAY.
        }

        int[] index = {0};

        return helper(preOrder, inOrder, 0, preOrder.length-1, map, index);
    }

    public TreeNode helper(int[] preOrder, int[] inOrder, int left, int right, HashMap<Integer, Integer> map, int[] index){
        if(left > right){  // base case how when the left length is more than right one
            return null;
        }
        //int index = 0;
        int current = preOrder[index[0]];
        index[0]++;

        // new Node creation
        TreeNode node = new TreeNode(current);

        if(left == right){
            return node;
        }

        int inorderIndex = map.get(current); // to find the index of the value of preOrder one in InOrder array

        // recrusive call off the left and right nodes
        node.left = helper(preOrder, inOrder, left, inorderIndex -1, map, index);
        node.right = helper(preOrder , inOrder, inorderIndex + 1, right, map, index ); // why only index+1 why not index
        // because the index is the node we already used


        // last step
        return node;

    }

    // without using this function we will get an address as like this tree.TreeNode@6acbcfc0

    // Utility function to print tree in Preorder
    public void printPreOrder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    public static void main(String[] args) {

        //int[] preorder = new int[3,9,20,15,7]; - wrong way to declare and intilaze the array
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        //int[] inorder = new int[9,3,15,20,7];

        HashmapTreeBinary obj = new HashmapTreeBinary();


        TreeNode root = obj.buildTree(preorder, inorder);

        //System.out.println(obj.buildTree()); - why this is wrong and wont print the results?

        obj.printPreOrder(root);


    }



}


// Time Complexity = O(N)  due to n recrusive calls
// Space Complexity = O(N)  due to storing of the array slices in the map
