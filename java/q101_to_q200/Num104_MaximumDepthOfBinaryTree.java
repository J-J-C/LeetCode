package q101_to_q200;

import utils.TreeNode;

public class Num104_MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));

    }
}
