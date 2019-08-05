package q101_to_q200;

import utils.TreeNode;

public class Num111_MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        int left = 1 + minDepth(root.left);
        int right = 1 + minDepth(root.right);

        if (left == 1 || right == 1) {
            return left < right ? right : left;
        } else {
            return left < right ? left : right;
        }
    }
}
