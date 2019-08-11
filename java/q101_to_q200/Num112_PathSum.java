package q101_to_q200;

import utils.TreeNode;

public class Num112_PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }

        boolean left = hasPathSum(root.left, sum - root.val);
        if (!left) {
            return hasPathSum(root.right, sum - root.val);
        } else {
            return left;
        }
    }
}
