package q101_to_q200;

import utils.TreeNode;

public class Num110_BalancedBinaryTree {


    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        int leftHeight = getTreeHeight(root.left);
        int rightHeight = getTreeHeight(root.right);

        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(leftHeight - rightHeight) <= 1;
    }



    public int getTreeHeight(TreeNode root) {
        if(root == null) {
            return  0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        return Math.max(1 + getTreeHeight(root.left), 1 +getTreeHeight(root.right));

    }

}
