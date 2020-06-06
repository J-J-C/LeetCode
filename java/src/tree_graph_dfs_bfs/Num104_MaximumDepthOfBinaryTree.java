package tree_graph_dfs_bfs;

import utils.TreeNode;

public class Num104_MaximumDepthOfBinaryTree {

    private int max = 0;

    public int maxDepth(TreeNode root) {
        maxDepth(root, 0);
        return max;
    }

    private void maxDepth(TreeNode root, int i) {
        if (root == null) {
            max = Math.max(i, max);
        } else if (root.left == null && root.right == null) {
            max = Math.max(i + 1, max);
        } else {
            maxDepth(root.left, i + 1);
            maxDepth(root.right, i + 1);
        }
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left_height = maxDepth(root.left);
            int right_height = maxDepth(root.right);
            return Math.max(left_height, right_height) + 1;
        }
    }
}
