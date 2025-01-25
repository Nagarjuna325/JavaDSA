package binarytrees;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        // how it it implemented using LinkedList right because in the above the TreeNode class forms a LinkedList? output we are seeing is in LinkedList right?

        if (root == null) {
            return null;
        }

        // Swap left and right child nodes
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively invert the left and right subtrees
        invertTree(root.left);
        invertTree(root.right);

        return root;

    }


    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        InvertBinaryTree bfs = new InvertBinaryTree();

        TreeNode result = bfs.invertTree(root); // why type is TreeNode not int?
        // because output is just the same list but inverted
        System.out.println(result);
    }
}

