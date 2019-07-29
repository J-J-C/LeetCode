package q101_to_q200;

import utils.TreeNode;

public class Num110_BalancedBinaryTree_Improved {


    public boolean isBalanced(TreeNode root) {
        balancedTree = true;
        int depth = getDepth(root);
        return balancedTree;
    }

    public int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = getDepth(node.left) + 1;
        int right = getDepth(node.right) + 1;

        if (left - right != -1 && left - right != 0 && left - right != 1) {
            balancedTree = false;
        }
        return Math.max(left, right);
    }

    public boolean balancedTree;
}
