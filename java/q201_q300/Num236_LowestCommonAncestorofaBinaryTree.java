package q201_q300;

import utils.TreeNode;

public class Num236_LowestCommonAncestorofaBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }
        if (root.left == p || root.right == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // if both exists, this means root is the ancestor
        if (left != null && right != null) {
            return root;
        }
        // we found the ancestor on the left side
        if (left != null) {
            return left;
        }
        // we found on the right side
        if (right != null) {
            return right;
        }
        // DNE
        return null;
    }
}
