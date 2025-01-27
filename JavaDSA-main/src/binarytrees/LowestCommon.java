package binarytrees;

public class LowestCommon {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null){
            return null;
        }

        if( root == p || root == q ){

            return root;
        }

        TreeNode left = lowestCommonAncestor( root.left, p, q);
        TreeNode right = lowestCommonAncestor( root.right, p , q);

        if( left != null && right != null){
            return root;
        }

        return left == null ? right : left;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        TreeNode p ;
        TreeNode q ;

        LowestCommon vas= new LowestCommon(); // creating a object to the class

        //vas.lowestCommonAncestor(root, 3 , 4);



    }

}
