package binarytrees;

public class DiameterDFS {

    // post order traversal is followed in this
    // how first we get the left height then we move to the right side to get right height then to node

    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        height(root);
        return diameter - 1;
    }

    int height(TreeNode node){

        if( node == null){
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        int dia = leftHeight + rightHeight + 1;
        diameter = Math.max(diameter , dia);

        return Math.max(leftHeight , rightHeight) + 1;

    }


    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        DiameterDFS bfs = new DiameterDFS();

        int result = bfs.diameterOfBinaryTree(root);
        System.out.println(result);
    }
}
